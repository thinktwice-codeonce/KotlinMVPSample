package com.bss.codebase.service.authentication

import com.bss.codebase.service.authentication.model.LoginRequest
import com.bss.codebase.service.authentication.model.LoginResponse
import com.bss.codebase.service.authentication.model.LoginSocialRequest
import com.orhanobut.hawk.Hawk

abstract class BaseAuthenticationManger<
        TUser : LoginResponse,
        TLoginRequest : LoginRequest,
        TLoginSocialRequest : LoginSocialRequest>(
    var configuration: AuthenticationManagerConfiguration
) : AuthenticationManager<TUser, TLoginRequest, TLoginSocialRequest> {

    protected lateinit var user: TUser;

    override fun getCurrentUser(): TUser {
        return user;
    }

    override fun setCurrentUser(currentUser: TUser) {
        this.user = currentUser;
        if (configuration.useStorage && Hawk.isBuilt()) {
            if (currentUser == null) {
                Hawk.remove(configuration.uniqueStorageKey)
            } else {
                Hawk.put(configuration.uniqueStorageKey, currentUser);
            }
        }
    }

}