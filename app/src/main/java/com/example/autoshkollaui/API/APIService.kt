package com.example.autoshkollaui.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIService {
    @GET("v1/search")
    fun getData(
        @Query("query") query: String,
        @Query("per_page") per_page: Int,
        @Header("Authorization") apiKey: String
    ): Call<APIResponse>
}