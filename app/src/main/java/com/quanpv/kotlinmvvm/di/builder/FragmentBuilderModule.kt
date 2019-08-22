package com.quanpv.kotlinmvvm.di.builder

import com.quanpv.kotlinmvvm.view.fragment.CoinListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeCoinListFragment(): CoinListFragment
}