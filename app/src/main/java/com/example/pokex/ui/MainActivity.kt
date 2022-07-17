package com.example.pokex.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokex.App.App
import com.example.pokex.ui.nav.Navigation
import com.example.pokex.ui.nav.ViewModels
import com.example.pokex.ui.view_model.main_screen_view_model.MainScreenViewModel
import com.example.pokex.ui.view_model.main_screen_view_model.MainScreenViewModuleFactory
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    @Inject
    lateinit var vmFactory: MainScreenViewModuleFactory
    val mainScreenViewModel by lazy {
        ViewModelProvider(this, vmFactory).get(MainScreenViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            val navHostController = rememberNavController()
            (getApplicationContext() as App).appComponent.injectMainActivity(this)
            Navigation(navHostController = navHostController, viewModels = ViewModels(
                mainScreenViewModel = mainScreenViewModel
            ))

        }
    }


}

