package com.example.amphibians_selftry.data

import com.example.amphibians_selftry.network.AmphibiansApi
import com.example.amphibians_selftry.network.AmphibiansDataClass

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<AmphibiansDataClass>
}

class NetworkAmphibiansRepository(): AmphibiansRepository {
    override suspend fun getAmphibians(): List<AmphibiansDataClass> {
        return AmphibiansApi.retrofitService.getAmphibians()
    }
}