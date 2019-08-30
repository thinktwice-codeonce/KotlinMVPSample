package com.bss.codebase.app.service.posts

import com.bss.codebase.app.service.model.response.Posts
import com.bss.codebase.service.network.provider.NetworkProvider
import rx.Observable

class DefaultPostsService(
    private val networkProvider: NetworkProvider,
    private val restPostsService: RestPostsService
) : PostsService {

    override fun getPosts(): Observable<List<Posts>> {
        return networkProvider.verifyResponse(restPostsService.getPosts())
    }
}