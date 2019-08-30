package com.bss.codebase.app.domain.module

import android.content.Context
import com.bss.codebase.BuildConfig
import com.bss.codebase.app.domain.service.authentication.AuthenticationService
import com.bss.codebase.app.domain.service.authentication.DefaultAuthenticationService
import com.bss.codebase.app.domain.service.authentication.RestAuthenticationService
import com.bss.codebase.app.domain.service.posts.DefaultPostsService
import com.bss.codebase.app.domain.service.posts.PostsService
import com.bss.codebase.app.domain.service.posts.RestPostsService
import com.bss.codebase.app.domain.util.ApiUrls
import com.bss.codebase.infrastructure.scope.ApplicationScope
import com.bss.codebase.service.network.provider.DefaultNetworkProvider
import com.bss.codebase.service.network.provider.NetworkProvider
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val context: Context) {

    @Provides
    @ApplicationScope
    fun provideNetworkProvider(): NetworkProvider {
        return DefaultNetworkProvider(context, BuildConfig.DEBUG)
    }

    @Provides
    @ApplicationScope
    fun provideAuthenticationService(networkProvider: NetworkProvider): AuthenticationService {
        return DefaultAuthenticationService(networkProvider,
            networkProvider.provideApi(ApiUrls.BASE_URL, RestAuthenticationService::class.java))
    }

    @Provides
    @ApplicationScope
    fun providePostsService(networkProvider: NetworkProvider) : PostsService {
        return DefaultPostsService(networkProvider, networkProvider.provideApi(ApiUrls.BASE_URL,
            RestPostsService::class.java))
    }
}