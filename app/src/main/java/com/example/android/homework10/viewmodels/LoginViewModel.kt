package com.example.android.homework10.viewmodels


import android.util.Base64
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.homework10.entities.LoginData
import com.example.android.homework10.livedata.SingleLiveEvent
import com.example.android.homework10.repos.GitHubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {

    private val _authLiveEvent: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val authLiveEvent: LiveData<Boolean> = _authLiveEvent
    val repository = GitHubRepository()

    fun onLoginClicked(email: String, password: String) {
        val base = "$email:$password"
        val authHeader: String = "Basic " + Base64.encodeToString(base.toByteArray(), Base64.NO_WRAP)

        repository.authorize(authHeader).enqueue(object : Callback<LoginData> {
            override fun onFailure(call: Call<LoginData>, t: Throwable) {
                _authLiveEvent.value = false
            }

            override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                Log.e("onResponse", "$response")
                if (response.isSuccessful) {
                    _authLiveEvent.value = true
                }
            }

        })
    }
}