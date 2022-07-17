package com.example.pokex.data.retrofit.model.response

import com.example.pokex.domain.model.ElementOfPokeList

data class Result(
    val name: String,
    val url: String
)

fun Result.toElementOfPokeList():ElementOfPokeList{
    return ElementOfPokeList(
        url = url,
        name = name
    )
}