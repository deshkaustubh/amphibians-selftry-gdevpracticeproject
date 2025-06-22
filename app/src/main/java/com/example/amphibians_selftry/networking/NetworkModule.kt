package com.example.amphibians_selftry.networking

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    fun provideAmphibiansApiService(retrofit: Retrofit): AmphibiansApiService {
        return retrofit.create(AmphibiansApiService::class.java)
    }
}