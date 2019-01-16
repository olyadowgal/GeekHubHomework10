package com.example.android.homework10.repos

import com.example.android.homework10.entities.GitHubData
import com.example.android.homework10.entities.LoginData
import com.example.android.homework10.network.GitHubService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/users/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val gitHubService = retrofit.create(GitHubService::class.java)

    fun getData(user: String): Call<GitHubData> {
        return gitHubService.getCurrentProfile(user)
    }

    fun authorize(loginHeader: String): Call<LoginData> {
        return gitHubService.authorizeUser(loginHeader)
    }
}
