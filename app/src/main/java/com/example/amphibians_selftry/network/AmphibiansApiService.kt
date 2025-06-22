package com.example.amphibians_selftry.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AmphibiansApiService {
    @GET("amphibians")
    fun getAmphibians(): String
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


