package com.example.pokex.data.retrofit.repository

import com.example.pokex.data.retrofit.api.RetrofitInstance
import com.example.pokex.data.retrofit.model.response.Pokemon
import com.example.pokex.data.retrofit.model.response.PokemonList

class RetrofitRepository:RetrofitInterface {

    override suspend fun getPokemonList(offset: Int, limit: Int): PokemonList {
        return RetrofitInstance().api.getPokemonList(offset = offset,limit = limit)
    }

    override suspend fun getPokemonByName(name: String): Pokemon {
        return RetrofitInstance().api.getPokemonInfo(name = name)
    }

}