package com.example.pokex.ui.view_model.main_screen_view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokex.Until.Resource
import com.example.pokex.domain.model.ElementOfPokeList
import com.example.pokex.domain.use_case.UseGetPokemonByName
import com.example.pokex.domain.use_case.UseGetPokemonList
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onErrorResume

class MainScreenViewModel(
    val useGetPokemonList: UseGetPokemonList,
    val useGetPokemonByName: UseGetPokemonByName
):ViewModel() {

    private val _state = mutableStateOf(PokeListState())
    val state: State<PokeListState> = _state

    private val _state_one_pokemon = mutableStateOf(PokeState())
    val pokemonState:State<PokeState> = _state_one_pokemon

    private val _state_lazy_column = mutableStateOf(LazyColumnState())
    val stateLazyColumn: State<LazyColumnState> = _state_lazy_column

    private val _state_data = mutableStateOf(PokeListState())
    val stateData: State<PokeListState> = _state_data


    init {
        getPokeList(5,5)
    }

     fun getPokemonByName(name:String){
        useGetPokemonByName(name).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("data","serv")
                    _state_one_pokemon.value = PokeState(info = result.data ?: null)
                }
                is Resource.Error -> {
                    Log.d("state",result.message.toString())
                    _state_one_pokemon.value = PokeState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    Log.d("state","load")
                    _state_one_pokemon.value = PokeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }



    private fun getPokeList(offset:Int,limit:Int) {
        useGetPokemonList(offset,limit).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("serv","suc")
                    _state.value = PokeListState(info = result.data ?: ArrayList())
                }
                is Resource.Error -> {
                    Log.d("serv","err")
                    _state.value = PokeListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    Log.d("serv","load")
                    _state.value = PokeListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}