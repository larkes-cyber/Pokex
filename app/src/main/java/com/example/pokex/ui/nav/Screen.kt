package com.example.pokex.ui.nav

sealed class Screen(val route:String) {

    object MainScreen:Screen("main_screen")
    object DetailScreen:Screen("detail_screen")

    fun withArg(vararg args:String):String{

        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }

    }

}