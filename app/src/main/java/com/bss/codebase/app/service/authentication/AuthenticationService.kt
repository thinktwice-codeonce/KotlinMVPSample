package com.bss.codebase.app.service.authentication

import com.bss.codebase.app.service.model.request.LoginInfo
import com.bss.codebase.app.service.model.response.User
import rx.Observable

interface AuthenticationService {
    fun signIn(loginInfo: LoginInfo): Observable<User>
}