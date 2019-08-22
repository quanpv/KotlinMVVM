package com.quanpv.kotlinmvvm

import com.quanpv.kotlinmvvm.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {

    companion object {
        private lateinit var sInstance: App

        fun getAppContext(): App {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }


override fun applicationInjector(): AndroidInjector<out App> {
    return DaggerAppComponent.builder().create(this)
}
}