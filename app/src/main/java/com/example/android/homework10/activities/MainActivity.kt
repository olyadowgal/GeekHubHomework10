package com.example.android.homework10

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.android.homework10.adapters.ReposAdapter
import com.example.android.homework10.entities.GitHubData
import com.example.android.homework10.network.GitHubService
import com.example.android.homework10.repos.GitHubRepository
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repos_list.layoutManager = LinearLayoutManager(this)
        repos_list.adapter = ReposAdapter()

    }
}