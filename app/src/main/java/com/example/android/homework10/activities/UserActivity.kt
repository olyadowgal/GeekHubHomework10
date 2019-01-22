package com.example.android.homework10.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.homework10.R
import com.example.android.homework10.entities.GitHubData
import com.example.android.homework10.repos.GitHubRepository
import com.example.android.homework10.userGitHubName
import com.example.android.homework10.viewmodels.MainViewModel
import com.example.android.homework10.viewmodels.UserViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by lazy {
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val position: Int = intent.getIntExtra("POSITION", 0)
        viewModel.getUserData(position)

        viewModel.userLiveEvent.observe(this, Observer {
            user_name.text = it.userName
            user_login.text = "@${it.userId}"
            user_repository.text = it.userReposAmount.toString()
            user_followers.text = it.userFollowersAmount.toString()
            user_following.text = it.userFollowingAmount.toString()

            Picasso.get().load(it.userImageSource).into(user_photo_url)
        })
    }
}
