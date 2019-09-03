package com.bss.codebase.app.service.authentication

import com.bss.codebase.app.service.model.request.LoginInfo
import com.bss.codebase.app.service.model.response.User
import com.bss.codebase.service.authentication.AuthenticationManagerConfiguration
import com.bss.codebase.service.authentication.BaseAuthenticationManger
import com.bss.codebase.service.authentication.model.LoginSocialRequest
import com.bss.codebase.service.network.provider.NetworkProvider
import rx.Observable

class DefaultAuthenticationService(val networkProvider: NetworkProvider,
                                                  val restAuthenticationService: RestAuthenticationService,
                                                   configuration: AuthenticationManagerConfiguration
): AuthenticationService,
    BaseAuthenticationManger<User, LoginInfo, LoginSocialRequest>(configuration) {
    override fun signIn(loginInfo: LoginInfo): Observable<User> {
        return login(loginInfo)
    }

    override fun onLogin(loginInfo: LoginInfo): Observable<User> {
        return networkProvider.verifyResponse(restAuthenticationService.signIn(loginInfo))
    }

    override fun onLoginSocial(loginSocialRequest: LoginSocialRequest): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout(): Observable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}