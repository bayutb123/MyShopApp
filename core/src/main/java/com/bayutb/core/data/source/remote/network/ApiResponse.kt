package com.bayutb.core.data.source.remote.network

sealed class ApiResponse<out R> {

    data class Success<out T>(val data : T): ApiResponse<T>()
    data class Error<out T>(val message : String): ApiResponse<T>()
    object Empty: ApiResponse<Nothing>()

}