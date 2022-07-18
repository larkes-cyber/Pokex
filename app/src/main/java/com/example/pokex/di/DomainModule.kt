package com.example.pokex.di

import com.example.pokex.domain.repository.UserRepository
import com.example.pokex.domain.use_case.UseGetPokemonByName
import com.example.pokex.domain.use_case.UseGetPokemonList
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideUseGetPokeList(userRepository: UserRepository):UseGetPokemonList{
        return UseGetPokemonList(
            userRepository = userRepository
        )
    }//hjohhhh[ihhh[ph

    @Provides
    fun provideUseGetPokemonByName(userRepository: UserRepository):UseGetPokemonByName{
        return UseGetPokemonByName(
            userRepository = userRepository
        )
    }
}