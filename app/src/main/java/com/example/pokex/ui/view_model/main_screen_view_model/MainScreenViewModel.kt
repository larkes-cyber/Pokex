package com.example.pokex.ui.view_model.main_screen_view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokex.Until.Resource
import com.example.pokex.domain.model.ElementOfPokeList
import com.example.pokex.domain.use_case.UseGetPokemonList
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainScreenViewModel(
    val useGetPokemonList: UseGetPokemonList
):ViewModel() {

    private val _state = mutableStateOf(PokeListState())
    val state: State<PokeListState> = _state

    init {
        getPokeList(120,120)
    }

    private fun getPokeList(offset:Int,limit:Int) {
        useGetPokemonList(offset,limit).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokeListState(info = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PokeListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PokeListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}