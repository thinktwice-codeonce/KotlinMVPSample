package com.bss.codebase.app.domain.main

import com.bss.codebase.app.service.authentication.AuthenticationService
import com.bss.codebase.app.service.model.request.LoginInfo
import com.bss.codebase.app.service.posts.PostsService
import com.bss.codebase.service.schedule.RxScheduler
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject


class MainPresenter @Inject constructor(private val postsService: PostsService)
    : MvpBasePresenter<MainView>() {

    @Inject
    lateinit var authenticationService: AuthenticationService

    fun signIn(loginRequest: LoginInfo) {
        authenticationService.signIn(loginRequest)
            .compose(RxScheduler.applyIoSchedulers())
            .subscribe({user ->
                ifViewAttached {mainView ->
                    mainView.onSignInSuccessful(user)
                }
            }, {throwable ->
                ifViewAttached {mainView ->
                    mainView.onSignInFailed(throwable)
                }
            })
    }

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