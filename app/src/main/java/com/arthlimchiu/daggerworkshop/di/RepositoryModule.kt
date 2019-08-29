package com.arthlimchiu.daggerworkshop.di

import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.repos.ReposRepository
import com.arthlimchiu.daggerworkshop.repos.ReposRepositoryImpl
import com.arthlimchiu.daggerworkshop.userdetails.UserRepository
import com.arthlimchiu.daggerworkshop.userdetails.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(api: Api): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesReposRepository(api: Api): ReposRepository {
        return ReposRepositoryImpl(api)
    }
}