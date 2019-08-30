package com.bss.codebase.app.domain.service.posts

import com.bss.codebase.app.domain.service.model.response.Posts
import rx.Observable

interface PostsService {

    fun getPosts(): Observable<List<Posts>>
}