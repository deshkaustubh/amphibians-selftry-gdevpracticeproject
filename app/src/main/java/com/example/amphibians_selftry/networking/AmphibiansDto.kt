package com.example.amphibians_selftry.networking

import kotlinx.serialization.SerialName


// Data Transfer Object - what comes from the api
data class AmphibiansDto (
    val name: String,
    val type:String,
    val description: String,
    val imageUrl: String
)

// domain model used within your app
data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    val imageUrl:String,
)