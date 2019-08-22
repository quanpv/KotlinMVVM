package com.quanpv.kotlinmvvm.view.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.stream.MalformedJsonException
import com.quanpv.kotlinmvvm.App
import com.quanpv.kotlinmvvm.R
import com.quanpv.kotlinmvvm.service.Resource
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

abstract class BaseViewModel<T> : ViewModel() {
    val response: MutableLiveData<Resource<T>> = MutableLiveData()

    val loadingStatus: MutableLiveData<Resource<Boolean>> = MutableLiveData()

    fun getCustomErrorMessage(error: Throwable): String {

        return when (error) {
            is SocketTimeoutException -> App.getAppContext().getString(R.string.requestTimeOutError)
            is MalformedJsonException -> App.getAppContext().getString(R.string.responseMalformedJson)
            is IOException -> App.getAppContext().getString(R.string.networkError)
            is HttpException -> error.response()!!.message()
            else -> App.getAppContext().getString(R.string.unknownError)
        }

    }
}