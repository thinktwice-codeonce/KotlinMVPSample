package com.bss.codebase.app.domain.module

import com.bss.codebase.app.domain.main.MainActivity
import com.bss.codebase.infrastructure.scope.ApplicationScope
import dagger.Component

@Component(modules = [ApplicationModule::class])
@ApplicationScope
interface ApplicationComponent {
    fun injectMain(activity: MainActivity)
}