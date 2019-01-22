package com.example.android.homework10.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.homework10.R
import com.example.android.homework10.entities.LoginData
import com.example.android.homework10.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {


    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val email: String = f_username.text.toString()
            val password: String = f_password.text.toString()
            viewModel.onLoginClicked(email, password)
        }


        viewModel.authLiveEvent.observe(this, Observer {
            if (it == true) {
                Toast.makeText(this@LoginActivity, "Omedeto! You are logged in.", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            } else {
                Toast.makeText(this@LoginActivity, "Something went wrong.", Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }


}
