package com.bss.codebase.app.service.model.request

import com.bss.codebase.service.authentication.model.LoginRequest
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginInfo: LoginRequest, Serializable {

    @SerializedName("username")
    private var userName: String = "phongit168"

    @SerializedName("password")
    private var userPassword: String = "12345678"

    override fun getUsername(): String {
        return userName
    }

    override fun setUsername(username: String) {
        this.userName = username
    }

    override fun getPassword(): String {
        return userPassword
    }

    override fun setPassword(password: String) {
        this.userPassword = password
    }
}