package com.bss.codebase.app.domain.main

import android.util.Log
import com.bss.codebase.app.domain.service.authentication.AuthenticationService
import com.bss.codebase.service.schedule.RxScheduler
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject


class MainPresenter @Inject constructor(private val authenticationService: AuthenticationService)
    : MvpBasePresenter<MainView>() {

    fun getPosts() {
        authenticationService.getPosts()
            .compose(RxScheduler.applyIoSchedulers())
            .subscribe({
                Log.d("Success", "Result: " + it.size)
            }, {
                Log.d("Error", "Error message: " + it.message)
            })
    }
}