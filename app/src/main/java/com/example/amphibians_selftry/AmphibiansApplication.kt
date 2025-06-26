package com.example.amphibians_selftry

import android.app.Application
import com.example.amphibians_selftry.data.AppContainer
import com.example.amphibians_selftry.data.DefaultAppContainer

class AmphibiansApplication : Application() {
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}