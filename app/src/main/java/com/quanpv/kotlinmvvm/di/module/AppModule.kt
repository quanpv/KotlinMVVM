package com.quanpv.kotlinmvvm.di.module

import com.quanpv.kotlinmvvm.service.ApiService
import com.quanpv.kotlinmvvm.service.repository.CoinRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: ApiService): CoinRepository {
        return CoinRepository(api)
    }

}