package com.example.amphibians_selftry.networking

import kotlinx.serialization.SerialName

data class Amphibians (
    val name: String,
    val type:String,
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)