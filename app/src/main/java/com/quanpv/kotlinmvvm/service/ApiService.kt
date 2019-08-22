package com.quanpv.kotlinmvvm.service

import com.quanpv.kotlinmvvm.model.CoinModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("v1/ticker")
    fun loadAllCoin(@QueryMap param: Map<String, String>): Observable<List<CoinModel>>
}