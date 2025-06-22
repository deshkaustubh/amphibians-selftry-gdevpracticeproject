package com.example.amphibians_selftry.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) // This line tells Retrofit to use Kotlinx Serialization to automatically convert JSON data from the API into Kotlin objects, and vice versa, using the "application/json" content type.
    .baseUrl(BASE_URL)
    .build()

/*
Retrofit uses the return type of the getAmphibians() function (List<AmphibiansDataClass>) to know what data to expect from the API. The AmphibiansDataClass is your Kotlin data class that matches the JSON structure returned by the API.  Here's how it works:
You define AmphibiansDataClass to match the API response fields.
Retrofit, with the help of the converter (Json.asConverterFactory), automatically parses the JSON response into a list of AmphibiansDataClass objects.
When you call getAmphibians(), Retrofit fetches the data and deserializes it into your data class.
This setup ensures type safety and easy access to the API data as Kotlin objects. The data class is essential for mapping the JSON response to usable Kotlin objects in your app.
 */
interface AmphibiansApiService {
    @GET("amphibians")
    fun getAmphibians(): List<AmphibiansDataClass>
}

// object declarations are singletons and are used to ensure that only one instance of
// object is created ans has one global point of access to the object it is thread safe and done at first access
// This is temporary and will replace this with dependency injection because this is not the recommended way to do things

// THE CALLS TO RETROFIT OBJECT IS EXPENSIVE AND HAS TO BE MADE ONLY ONCE SO THE OBJECT HAS TO BE
// PUBLIC SINGLETON THAT THE REST OF THE APP COULD ACCESS

object AmphibiansApi {
    val retrofitService: AmphibiansApiService by lazy {
        //This line uses Retrofit to create an implementation of the AmphibiansApiService interface. The ::class.java part gets the Java class reference needed by Retrofit. This allows you to call the API methods defined in AmphibiansApiService as if they were regular Kotlin functions, and Retrofit handles the network requests for you.
        retrofit.create(AmphibiansApiService::class.java) //::class.java is Kotlin syntax used to get the Java Class object of a Kotlin class. For example, AmphibiansApiService::class.java returns the Java Class reference for AmphibiansApiService, which is needed by Java-based libraries like Retrofit to create instances or perform reflection.
    }
}


