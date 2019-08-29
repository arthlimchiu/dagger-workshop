package com.arthlimchiu.daggerworkshop.repos

import com.arthlimchiu.daggerworkshop.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ReposModule::class
    ]
)
interface ReposSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): ReposSubcomponent
    }

    fun inject(activity: ReposActivity)
}