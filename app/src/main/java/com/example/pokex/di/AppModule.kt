package com.example.pokex.di

import android.content.Context
import com.example.pokex.domain.use_case.UseGetPokemonByName
import com.example.pokex.domain.use_case.UseGetPokemonList
import com.example.pokex.ui.view_model.main_screen_view_model.MainScreenViewModuleFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext():Context{
        return context
    }

    @Provides
    fun provideMainScreenViewModelFactory(
         useGetPokemonList: UseGetPokemonList,
         useGetPokemonByName: UseGetPokemonByName
    ):MainScreenViewModuleFactory{
        return MainScreenViewModuleFactory(
            useGetPokemonList = useGetPokemonList,
            useGetPokemonByName = useGetPokemonByName
        )
    }

}