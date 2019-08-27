package com.bss.codebase.app.domain.application

import android.app.Application
import com.bss.codebase.app.domain.module.ApplicationComponent
import com.bss.codebase.app.domain.module.ApplicationModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ApplicationModule(this)

    }
}