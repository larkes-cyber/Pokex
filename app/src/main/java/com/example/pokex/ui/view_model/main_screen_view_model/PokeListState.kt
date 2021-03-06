package com.example.pokex.ui.view_model.main_screen_view_model

import com.example.pokex.domain.model.ElementOfPokeList

data class PokeListState(
    val isLoading: Boolean = false,
    var info: MutableList<ElementOfPokeList>? = null,
    val error: String = ""
)