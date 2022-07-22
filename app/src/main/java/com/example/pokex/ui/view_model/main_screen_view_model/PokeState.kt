package com.example.pokex.ui.view_model.main_screen_view_model

import com.example.pokex.domain.model.ElementOfPokeList

class PokeState(
    val isLoading: Boolean = false,
    var info: ElementOfPokeList? = null,
    val error: String = ""
)