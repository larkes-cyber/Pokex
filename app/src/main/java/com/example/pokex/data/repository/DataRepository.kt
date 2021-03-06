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

    override suspend fun getPokemonList(offset: Int, limit: Int):MutableList<ElementOfPokeList> {
        val resp =  retrofitRepository.getPokemonList(offset = offset,limit = limit)
            .results

        val mutableList:MutableList<ElementOfPokeList> = resp.map { it.toElementOfPokeList()  } as MutableList<ElementOfPokeList>

        return mutableList
    }

    override suspend fun getPokemonByName(name: String):ElementOfPokeList {
        return retrofitRepository.getPokemonByName(name = name).toElementOfPokeList()
    }
}

fun Pokemon.toElementOfPokeList():ElementOfPokeList{
    return ElementOfPokeList(
        url = "sprites.other.official_artwork.front_default",
        name = forms[0].name
    )
}