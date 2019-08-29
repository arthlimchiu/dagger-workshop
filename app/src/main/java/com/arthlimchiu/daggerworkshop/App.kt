package com.arthlimchiu.daggerworkshop

import android.app.Application
import com.arthlimchiu.daggerworkshop.di.AppComponent
import com.arthlimchiu.daggerworkshop.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .build()
    }
}

lateinit var appComponent: AppComponent