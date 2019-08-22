package com.quanpv.kotlinmvvm.service.repository

import com.quanpv.kotlinmvvm.model.CoinModel
import com.quanpv.kotlinmvvm.service.ApiService
import io.reactivex.Observable
import java.util.HashMap
import javax.inject.Inject

open class CoinRepository @Inject constructor(private val service: ApiService) {

    fun loadAllCoin(total: String): Observable<List<CoinModel>> {
        val params = HashMap<String, String>()
        params["limit"] = total
        return service.loadAllCoin(params)
    }

}