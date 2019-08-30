package com.bss.codebase.app.domain.service.authentication

import com.bss.codebase.app.domain.service.model.Posts
import com.bss.codebase.service.network.provider.NetworkProvider
import rx.Observable

class DefaultAuthenticationService(val networkProvider: NetworkProvider,
                                   val restAuthenticationService: RestAuthenticationService): AuthenticationService {

    override fun getPosts(): Observable<List<Posts>> {
        return networkProvider.verifyResponse(restAuthenticationService.getPosts())
    }

}