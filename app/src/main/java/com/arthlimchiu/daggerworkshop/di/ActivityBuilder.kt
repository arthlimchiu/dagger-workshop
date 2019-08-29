package com.arthlimchiu.daggerworkshop.di

import com.arthlimchiu.daggerworkshop.repos.ReposActivity
import com.arthlimchiu.daggerworkshop.repos.ReposModule
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsActivity
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [UserDetailsModule::class])
    abstract fun userDetailsActivity(): UserDetailsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ReposModule::class])
    abstract fun reposActivity(): ReposActivity
}