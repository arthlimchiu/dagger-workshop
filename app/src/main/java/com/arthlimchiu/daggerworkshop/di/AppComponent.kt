package com.arthlimchiu.daggerworkshop.di

import com.arthlimchiu.daggerworkshop.repos.ReposActivity
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(activity: UserDetailsActivity)

    fun inject(activity: ReposActivity)
}