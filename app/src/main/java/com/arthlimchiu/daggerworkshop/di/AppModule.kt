package com.arthlimchiu.daggerworkshop.di

import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.repos.ReposSubcomponent
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsSubcomponent
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(
    subcomponents = [
        ReposSubcomponent::class,
        UserDetailsSubcomponent::class
    ]
)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}