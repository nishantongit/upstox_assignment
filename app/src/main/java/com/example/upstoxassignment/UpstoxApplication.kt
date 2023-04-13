package com.example.upstoxassignment

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.upstoxassignment.base.di.AppComponent

class UpstoxApplication : MultiDexApplication() {
    lateinit var appComponent: AppComponent


    companion object {
        lateinit var CONTEXT: Context
    }

    override fun onCreate() {
        super.onCreate()
        inject()
        CONTEXT = applicationContext
    }

    fun getInstance(): UpstoxApplication {
        return this
    }

    fun inject() {
        CONTEXT = applicationContext

//        appComponent = DaggerAppComponent.builder().application(this).build()
//        appComponent.inject(this)
    }

}