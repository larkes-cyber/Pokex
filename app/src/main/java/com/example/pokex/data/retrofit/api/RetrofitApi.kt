package com.example.pokex.data.retrofit.api

import com.example.pokex.data.retrofit.model.response.Pokemon
import com.example.pokex.data.retrofit.model.response.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset:Int,
        @Query("limit") limit:Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name:String
    ): Pokemon
}