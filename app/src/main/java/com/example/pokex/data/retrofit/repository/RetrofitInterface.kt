package com.example.pokex.data.retrofit.repository

import com.example.pokex.data.retrofit.model.response.Pokemon
import com.example.pokex.data.retrofit.model.response.PokemonList

interface RetrofitInterface {

    suspend fun getPokemonList(offset:Int,limit:Int): PokemonList
    suspend fun getPokemonByName(name:String):Pokemon

}