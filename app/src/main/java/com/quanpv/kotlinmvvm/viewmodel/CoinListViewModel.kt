package com.quanpv.kotlinmvvm.viewmodel

import com.quanpv.kotlinmvvm.model.CoinModel
import com.quanpv.kotlinmvvm.service.Resource
import com.quanpv.kotlinmvvm.service.repository.CoinRepository
import com.quanpv.kotlinmvvm.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CoinListViewModel @Inject
constructor(coinRepository: CoinRepository) : BaseViewModel<List<CoinModel>>() {

    init {
            coinRepository.loadAllCoin("100")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    loadingStatus.value =  Resource.loading(true)
                }
                .doFinally {
                    loadingStatus.value =  Resource.loading(false)
                }
                .subscribe({
                        response.value = Resource.success(it)
                }, {
                    response.value = Resource.error(getCustomErrorMessage(it), ArrayList())
                    print(it.message)
                })
    }

}