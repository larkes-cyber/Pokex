package com.example.pokex.domain.repository

import com.example.pokex.data.retrofit.model.response.Pokemon
import com.example.pokex.data.retrofit.model.response.PokemonList
import com.example.pokex.domain.model.ElementOfPokeList

interface UserRepository {

    suspend fun getPokemonList(offset:Int,limit:Int):List<ElementOfPokeList>
    suspend fun getPokemonByName(name:String):ElementOfPokeList

}