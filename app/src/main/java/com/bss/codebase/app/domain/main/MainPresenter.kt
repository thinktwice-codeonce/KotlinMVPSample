package com.bss.codebase.app.domain.main

import com.bss.codebase.app.service.posts.PostsService
import com.bss.codebase.service.schedule.RxScheduler
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject


class MainPresenter @Inject constructor(private val postsService: PostsService)
    : MvpBasePresenter<MainView>() {

    fun getPosts() {
        postsService.getPosts()
            .compose(RxScheduler.applyIoSchedulers())
            .subscribe({resultPosts ->
                ifViewAttached {mainView ->
                    mainView.onGetPostsSuccessful(resultPosts)
                }
            }, {throwable ->
                ifViewAttached {mainView ->
                    mainView.onGetPostsFailed(throwable)
                }
            })
    }
}