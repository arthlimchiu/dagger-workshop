package com.arthlimchiu.daggerworkshop.di

import com.arthlimchiu.daggerworkshop.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent {

    fun inject(app: App)
}