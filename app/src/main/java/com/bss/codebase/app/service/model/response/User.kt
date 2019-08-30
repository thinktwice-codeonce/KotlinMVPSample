package com.bss.codebase.app.service.model.response

import com.bss.codebase.service.authentication.model.LoginResponse
import com.google.gson.annotations.SerializedName

class User: LoginResponse {

    @SerializedName("username")
    var userName: String = ""

    @SerializedName("email")
    var userEmail: String = ""

    @SerializedName("accessToken")
    var userAccessToken: String = ""

    override fun getUsername(): String {
        return userName
    }

    override fun setUsername(username: String) {
        this.userName = username
    }

    override fun getEmail(): String {
       return userEmail
    }

    override fun setEmail(email: String) {
        this.userEmail = email
    }

    override fun getAccessToken(): String {
       return userAccessToken
    }

    override fun setAccessToken(token: String) {
        this.userAccessToken = token
    }

}