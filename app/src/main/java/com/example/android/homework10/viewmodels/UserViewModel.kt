package com.example.android.homework10.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.homework10.entities.GitHubData
import com.example.android.homework10.livedata.SingleLiveEvent
import com.example.android.homework10.repos.GitHubRepository
import com.example.android.homework10.userGitHubName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    private val repository = GitHubRepository()
    var dataResponse: GitHubData? = null
    private val _userLiveEvent: SingleLiveEvent<GitHubData> = SingleLiveEvent()
    val userLiveEvent: LiveData<GitHubData> = _userLiveEvent

    fun getUserData(position: Int) {
        val user = userGitHubName[position]
        repository.getData(user).enqueue(object : Callback<GitHubData> {
            override fun onResponse(call: Call<GitHubData>, response: Response<GitHubData>) {
                if (response.isSuccessful) {
                    dataResponse = response.body()!!
                    _userLiveEvent.value = dataResponse
                }
            }

            override fun onFailure(call: Call<GitHubData>, t: Throwable) {
            }
        })
    }
}