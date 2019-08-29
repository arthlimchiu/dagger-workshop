package com.arthlimchiu.daggerworkshop.userdetails

import com.arthlimchiu.daggerworkshop.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        UserDetailsModule::class
    ]
)
interface UserDetailsSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): UserDetailsSubcomponent
    }

    fun inject(activity: UserDetailsActivity)
}