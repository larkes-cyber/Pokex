package com.example.pokex.ui.view_model.main_screen_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokex.domain.use_case.UseGetPokemonByName
import com.example.pokex.domain.use_case.UseGetPokemonList

class MainScreenViewModuleFactory(
    val useGetPokemonList: UseGetPokemonList,
    val useGetPokemonByName: UseGetPokemonByName
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainScreenViewModel(
            useGetPokemonList = useGetPokemonList,
            useGetPokemonByName = useGetPokemonByName
        ) as T
    }
}