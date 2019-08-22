package com.quanpv.kotlinmvvm.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.quanpv.kotlinmvvm.viewmodel.CoinListViewModel
import com.quanpv.kotlinmvvm.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinListViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindsCoinListViewModel(coinListViewModel: CoinListViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
