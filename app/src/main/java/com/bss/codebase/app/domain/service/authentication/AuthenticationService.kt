package com.bss.codebase.app.domain.service.authentication

import com.bss.codebase.app.domain.service.model.Posts
import rx.Observable

interface AuthenticationService {

    fun getPosts(): Observable<List<Posts>>


}