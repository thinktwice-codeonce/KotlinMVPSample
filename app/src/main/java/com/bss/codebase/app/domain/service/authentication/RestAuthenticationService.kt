package com.bss.codebase.app.domain.service.authentication

import com.bss.codebase.app.domain.service.model.Posts
import retrofit2.http.GET
import rx.Observable

interface RestAuthenticationService {

    @GET("posts")
    fun getPosts(): Observable<List<Posts>>
}