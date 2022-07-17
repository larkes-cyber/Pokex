package com.example.pokex.data.retrofit.model.response

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)