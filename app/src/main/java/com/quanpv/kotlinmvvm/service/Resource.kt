package com.quanpv.kotlinmvvm.service

import androidx.annotation.NonNull
import androidx.annotation.Nullable

class Resource<out T> private constructor(@NonNull status: Status, @Nullable data: T, @Nullable message: String) {
    @NonNull
    val status: Status
    @Nullable
    val data: T
    @Nullable
    @get:Nullable
    val message: String

    init {
        this.status = status
        this.data = data
        this.message = message
    }

    companion object {
        fun <T> success(@NonNull data: T): Resource<T> {
            return Resource<T>(Status.SUCCESS, data, "")
        }

        fun <T> error(msg: String, @Nullable data: T): Resource<T> {
            return Resource<T>(Status.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T): Resource<T> {
            return Resource<T>(Status.LOADING, data, "")
        }
    }
}