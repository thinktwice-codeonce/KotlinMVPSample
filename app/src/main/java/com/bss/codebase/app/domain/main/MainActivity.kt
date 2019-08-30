package com.bss.codebase.app.domain.main

import android.annotation.SuppressLint
import android.widget.Toast
import com.bss.codebase.R
import com.bss.codebase.app.module.ApplicationModule
import com.bss.codebase.app.module.DaggerApplicationComponent
import com.bss.codebase.app.service.model.request.LoginInfo
import com.bss.codebase.app.service.model.response.Posts
import com.bss.codebase.app.service.model.response.User
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import org.androidannotations.annotations.AfterInject
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity
import javax.inject.Inject

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
class MainActivity : MvpActivity<MainView, MainPresenter>(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun createPresenter(): MainPresenter {
        return mainPresenter
    }

    @AfterInject
    fun afterInject() {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()
            .injectMain(this)
    }

    @AfterViews
    fun afterView() {
    }

    @Click(R.id.btnGetPosts)
    protected fun clickGetPosts() {
        mainPresenter.getPosts()
    }

    override fun onSignInSuccessful(user: User) {
        Toast.makeText(application, "SignIn successful: " + user.userName, Toast.LENGTH_SHORT).show()
    }

    override fun onSignInFailed(throwable: Throwable) {
        Toast.makeText(application, "SignIn error: " + throwable.message, Toast.LENGTH_SHORT).show()
    }


    override fun onGetPostsSuccessful(posts: List<Posts>) {
        Toast.makeText(application, "Posts size: " + posts.size, Toast.LENGTH_SHORT).show()
    }

    override fun onGetPostsFailed(throwable: Throwable) {
        Toast.makeText(application, "Get Posts Error: " + throwable.message, Toast.LENGTH_SHORT).show()
    }
}
