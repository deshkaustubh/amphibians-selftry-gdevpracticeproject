package com.example.amphibians_selftry.data

import com.example.amphibians_selftry.networking.Amphibian
import com.example.amphibians_selftry.networking.AmphibiansDto
import com.example.amphibians_selftry.networking.AmphibiansApiService

interface AmphibiansRepository{
    suspend fun getAmphibians() : Result<List<Amphibian>>
}

class DefaultAmphibianRepository(
    private val apiService: AmphibiansApiService
): AmphibiansRepository {
    override suspend fun getAmphibians(): Result<List<Amphibian>> = try {
        val amphibianDtos = apiService.getAmphibians()
        val amphibians = amphibianDtos.map {dto->
            Amphibian(
                name = dto.name,
                type = dto.type,
                description = dto.description,
                imageUrl = dto.imageUrl
            )
        }
        Result.success(amphibians)
    } catch (e: Exception) {
        Result.failure(e)
    }
}