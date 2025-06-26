package com.example.amphibians_selftry.data

import com.example.amphibians_selftry.network.AmphibiansApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val amphibiansRepository : AmphibiansRepository
}


class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) // This line tells Retrofit to use Kotlinx Serialization to automatically convert JSON data from the API into Kotlin objects, and vice versa, using the "application/json" content type.
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansRepository: AmphibiansRepository  by lazy {
        NetworkAmphibiansRepository(retrofitService)
    }

}