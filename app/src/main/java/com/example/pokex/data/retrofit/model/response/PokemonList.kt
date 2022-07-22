package com.example.pokex.data.retrofit.model.response

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: MutableList<Result>
)