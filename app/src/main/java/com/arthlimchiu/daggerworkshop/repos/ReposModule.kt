package com.arthlimchiu.daggerworkshop.repos

import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ReposModule {

    @Provides
    @ActivityScope
    fun providesReposRepository(api: Api): ReposRepository {
        return ReposRepositoryImpl(api)
    }
}