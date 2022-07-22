package com.example.pokex.ui.view_model.main_screen_view_model

import com.example.pokex.domain.model.ElementOfPokeList

class LazyColumnState(
    val isLoading: Boolean = false,
    var info: MutableList<ElementOfPokeList> = ArrayList(),
    val error: String = ""
)