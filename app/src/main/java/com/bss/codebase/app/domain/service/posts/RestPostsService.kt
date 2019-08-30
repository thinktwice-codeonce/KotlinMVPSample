package com.bss.codebase.app.domain.service.posts

import com.bss.codebase.app.domain.service.model.response.Posts
import retrofit2.http.GET
import rx.Observable

interface RestPostsService {

    @GET("posts")
    fun getPosts(): Observable<List<Posts>>
}