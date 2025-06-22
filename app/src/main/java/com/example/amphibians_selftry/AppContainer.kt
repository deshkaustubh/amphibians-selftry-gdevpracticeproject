package com.example.amphibians_selftry

import com.example.amphibians_selftry.data.AmphibiansRepository
import com.example.amphibians_selftry.data.DefaultAmphibianRepository
import com.example.amphibians_selftry.networking.NetworkModule


class AppContainer {
    // Create Retrofit instance
    private val retrofit = NetworkModule.provideRetrofit()

    // Create API service
    private val amphibiansApiService = NetworkModule.provideAmphibiansApiService(retrofit)

    // Create repository
    val amphibiansRepository: AmphibiansRepository = DefaultAmphibianRepository(amphibiansApiService)
}

