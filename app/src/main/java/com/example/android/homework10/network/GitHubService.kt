package com.example.android.homework10.network

import com.example.android.homework10.entities.GitHubData
import com.example.android.homework10.entities.LoginData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface GitHubService {

    @GET("{user}")
    fun getCurrentProfile(@Path("user") user: String): Call<GitHubData>

    @GET("user")
    fun authorizeUser(@Header("Authorization") authHeader: String): Call<LoginData>
}
