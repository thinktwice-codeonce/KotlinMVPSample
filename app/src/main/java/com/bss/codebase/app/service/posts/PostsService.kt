package com.bss.codebase.app.service.posts

import com.bss.codebase.app.service.model.response.Posts
import rx.Observable

interface PostsService {

    fun getPosts(): Observable<List<Posts>>
}