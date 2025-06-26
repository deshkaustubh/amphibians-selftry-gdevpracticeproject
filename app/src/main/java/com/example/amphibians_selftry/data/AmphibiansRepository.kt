package com.example.amphibians_selftry.data

import com.example.amphibians_selftry.network.AmphibiansApiService
import com.example.amphibians_selftry.network.AmphibiansDataClass

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<AmphibiansDataClass>
}

class NetworkAmphibiansRepository(private val amphibiansApiService: AmphibiansApiService) :
    AmphibiansRepository {
    override suspend fun getAmphibians(): List<AmphibiansDataClass> =
        amphibiansApiService.getAmphibians()
}