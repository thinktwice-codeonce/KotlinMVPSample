package com.bss.codebase.app.application

import android.app.Application
import com.bss.codebase.app.module.ApplicationModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ApplicationModule(this)

    }
}