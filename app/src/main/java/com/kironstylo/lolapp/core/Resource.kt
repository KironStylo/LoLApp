package com.kironstylo.lolapp.core

sealed class Resource<T> (val data: T? = null, val message: String? = null){
    class Loading<T> (data: T? = null): Resource<T>(data)
    class Success<T> (data: T? = null): Resource<T>(data)
    class Error<T> (message: String? = null, data: T? = null): Resource<T>(data)
}