package com.arthlimchiu.daggerworkshop.userdetails

import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class UserDetailsModule {

    @Provides
    @ActivityScope
    fun providesUserRepository(api: Api): UserRepository {
        return UserRepositoryImpl(api)
    }
}