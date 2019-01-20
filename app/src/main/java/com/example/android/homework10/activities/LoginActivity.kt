package com.example.android.homework10

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.example.android.homework10.entities.LoginData
import com.example.android.homework10.repos.GitHubRepository
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private val repository = GitHubRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val email: String = f_username.text.toString()
            val password: String = f_password.text.toString()
            login(email, password)
        }

    }

    fun login(email: String, password: String) {
        val base = "$email:$password"
        val authHeader: String = "Basic " + Base64.encodeToString(base.toByteArray(), Base64.NO_WRAP)
        authorization(authHeader)
    }

    private fun authorization(authHeader: String) {
        repository.authorize(authHeader).enqueue(object : Callback<LoginData> {
            override fun onFailure(call: Call<LoginData>, t: Throwable) {
                Log.e("onFailure", "${t.message}")
            }

            override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                Log.e("onResponse", "$response")
                if (response.isSuccessful) {
                    Toast.makeText(this@LoginActivity, "You have successfully logged in.", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
            }

        })
    }


}
