package com.example.android.homework10

import com.example.android.homework10.repos.GitHubRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {

    @GET("/users/{user}/repos")
    fun reposForUser(
        @Path("user") user: String
    ): Call<List<GitHubRepository>>

}