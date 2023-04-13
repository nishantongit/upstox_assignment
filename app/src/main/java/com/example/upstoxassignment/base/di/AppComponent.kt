package com.example.upstoxassignment.base.di

import com.example.upstoxassignment.UpstoxApplication
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(upstoxApplication: UpstoxApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(upstoxApplication: UpstoxApplication): Builder
        fun build(): AppComponent
    }
}