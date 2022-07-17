package com.example.pokex.App

import android.app.Application
import com.example.pokex.di.AppComponent
import com.example.pokex.di.AppModule
import com.example.pokex.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }
}