package com.bss.codebase.app.domain.main

import com.bss.codebase.app.service.model.response.Posts
import com.hannesdorfmann.mosby3.mvp.MvpView

interface MainView: MvpView {
    fun onGetPostsSuccessful(posts: List<Posts>)

    fun onGetPostsFailed(throwable: Throwable)
}