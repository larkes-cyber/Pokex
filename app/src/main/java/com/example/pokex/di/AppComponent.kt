package com.example.pokex.di

import com.example.pokex.ui.MainActivity
import dagger.Component

@Component(modules = [AppModule::class,DataModule::class,DomainModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}