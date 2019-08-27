package com.bss.codebase.app.domain.service.authentication

import com.bss.codebase.app.domain.service.model.Posts
import com.bss.codebase.service.network.provider.NetworkProvider
import rx.Observable

class DefaultAuthenticationService(networkProvider: NetworkProvider,
                                   restAuthenticationService: RestAuthenticationService): AuthenticationService {

    override fun getPosts(): Observable<List<Posts>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}