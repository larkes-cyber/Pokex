package com.example.pokex.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokex.ui.components.main_screen.MainScreen


@Composable
fun Navigation(navHostController: NavHostController,viewModels: ViewModels){
    NavHost(navController = navHostController, startDestination = "main_screen"){

        composable(Screen.MainScreen.route){
            MainScreen(
                navHostController = navHostController,
                vm = viewModels.mainScreenViewModel
            )
        }


    }
}