package com.arthlimchiu.daggerworkshop

import android.app.Application
import com.arthlimchiu.daggerworkshop.di.AppComponent
import com.arthlimchiu.daggerworkshop.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .build()
        appComponent.inject(this)
    }
}

lateinit var appComponent: AppComponent