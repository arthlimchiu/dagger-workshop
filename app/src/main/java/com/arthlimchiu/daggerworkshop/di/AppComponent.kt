package com.arthlimchiu.daggerworkshop.di

import com.arthlimchiu.daggerworkshop.repos.ReposSubcomponent
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun userDetailsSubcomponent(): UserDetailsSubcomponent.Builder

    fun reposSubcomponent(): ReposSubcomponent.Builder
}