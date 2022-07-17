package com.example.pokex.data.repository

import com.example.pokex.data.retrofit.model.response.Pokemon
import com.example.pokex.data.retrofit.model.response.PokemonList
import com.example.pokex.data.retrofit.model.response.toElementOfPokeList
import com.example.pokex.data.retrofit.repository.RetrofitRepository
import com.example.pokex.domain.model.ElementOfPokeList
import com.example.pokex.domain.repository.UserRepository

class DataRepository(
    val retrofitRepository: RetrofitRepository
):UserRepository {

    override suspend fun getPokemonList(offset: Int, limit: Int):List<ElementOfPokeList> {
        return  retrofitRepository.getPokemonList(offset = offset,limit = limit)
            .results
            .map { it.toElementOfPokeList() }
    }

    override suspend fun getPokemonByName(name: String):Pokemon {
        return retrofitRepository.getPokemonByName(name = name)
    }
}