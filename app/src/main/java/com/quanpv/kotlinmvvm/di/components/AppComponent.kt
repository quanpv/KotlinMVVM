package com.quanpv.kotlinmvvm.di.components

import com.quanpv.kotlinmvvm.App
import com.quanpv.kotlinmvvm.di.builder.ActivityBuilderModule
import com.quanpv.kotlinmvvm.di.module.AppModule
import com.quanpv.kotlinmvvm.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    AppModule::class,
    NetworkModule::class
])

interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}