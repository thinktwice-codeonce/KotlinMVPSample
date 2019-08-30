package com.bss.codebase.app.service.authentication

import com.bss.codebase.app.service.model.request.LoginInfo
import com.bss.codebase.app.service.model.response.User
import retrofit2.http.POST
import rx.Observable

interface RestAuthenticationService {

    @POST("posts")
    fun signIn(loginInfo: LoginInfo): Observable<User>
}