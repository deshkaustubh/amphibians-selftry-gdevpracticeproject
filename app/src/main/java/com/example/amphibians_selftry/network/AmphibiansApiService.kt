package com.example.amphibians_selftry.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET



/*
Retrofit uses the return type of the getAmphibians() function (List<AmphibiansDataClass>) to know what data to expect from the API. The AmphibiansDataClass is your Kotlin data class that matches the JSON structure returned by the API.  Here's how it works:
You define AmphibiansDataClass to match the API response fields.
Retrofit, with the help of the converter (Json.asConverterFactory), automatically parses the JSON response into a list of AmphibiansDataClass objects.
When you call getAmphibians(), Retrofit fetches the data and deserializes it into your data class.
This setup ensures type safety and easy access to the API data as Kotlin objects. The data class is essential for mapping the JSON response to usable Kotlin objects in your app.
 */
interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibiansDataClass>
    // ⚠️ IMPORTANT: Always use 'suspend' with Retrofit service functions when returning plain Kotlin types like List<T>
// Without 'suspend', Retrofit doesn't know how to adapt the return type and will throw:
// "IllegalArgumentException: Unable to create call adapter for List<...>"
// This is because we're using kotlinx.serialization with Json.asConverterFactory()
// Retrofit needs either:
// - suspend functions (for coroutine support)
// - or explicit wrappers like Call<T>, Flow<T>, etc.
// ✅ So always write:
// suspend fun getAmphibians(): List<AmphibiansDataClass>

}

// object declarations are singletons and are used to ensure that only one instance of
// object is created ans has one global point of access to the object it is thread safe and done at first access
// This is temporary and will replace this with dependency injection because this is not the recommended way to do things

// THE CALLS TO RETROFIT OBJECT IS EXPENSIVE AND HAS TO BE MADE ONLY ONCE SO THE OBJECT HAS TO BE
// PUBLIC SINGLETON THAT THE REST OF THE APP COULD ACCESS

object AmphibiansApi {

}


