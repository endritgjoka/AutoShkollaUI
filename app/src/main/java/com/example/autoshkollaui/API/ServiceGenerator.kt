package com.example.autoshkollaui.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private const val API_KEY = "Pyesk7uPdniTiCENNWVLq6HnR0ESr3tXcZCP1Vk7MdinmMosp3w56GbW"
    private const val BASE_URL = "https://api.pexels.com/"

    private val retrofit:Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
    }

//    fun <T> buildService(service: Class<T>): T {
//        return retrofit.create(service)
//    }
    val apiService:APIService by lazy{
        retrofit.create(APIService::class.java)
    }
}
