package com.example.amphibians_selftry.data

import com.example.amphibians_selftry.networking.Amphibians
import com.example.amphibians_selftry.networking.AmphibiansApiService

interface AmphibiansRepository{
    suspend fun getAmphibians() : List<Amphibians>
}

class NetworkAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
):AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibians> = amphibiansApiService.getAmphibians()
}