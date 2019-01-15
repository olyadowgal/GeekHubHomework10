package com.example.android.homework10

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
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

        val API_BASE_URL = "https://api.github.com/"

        val httpClient = OkHttpClient.Builder()

        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )

        val retrofit = builder
            .client(
                httpClient.build()
            )
            .build()


        // Create a very simple REST adapter which points the GitHub API endpoint.
        val client = retrofit.create(GitHubService::class.java)

// Fetch a list of the Github repositories.
        val call = client.reposForUser("olyadowgal")

// Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(object : Callback<List<GitHubRepository>> {

            override fun onResponse(call: Call<List<GitHubRepository>>, response: Response<List<GitHubRepository>>) {
                val repos = response.body()
                repos_list.layoutManager = LinearLayoutManager(this@MainActivity)
                repos_list.adapter = ReposAdapter(repos!!)

            }

            override fun onFailure(call: Call<List<GitHubRepository>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_LONG ).show()
            }
        })
    }
}
