package com.example.android.homework10.entities

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("login") val login: String,
    @SerializedName("code") val code: Int
)