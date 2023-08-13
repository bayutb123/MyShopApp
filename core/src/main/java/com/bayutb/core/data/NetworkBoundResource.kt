package com.bayutb.core.data

import com.bayutb.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<com.bayutb.core.data.Resource<ResultType>> = flow {
        emit(com.bayutb.core.data.Resource.Loading())
        val db = loadFromDB().first()
        if (shouldFetch(db)) {
            emit(com.bayutb.core.data.Resource.Loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCall(apiResponse.data)
                    emitAll(loadFromDB().map { com.bayutb.core.data.Resource.Success(it) })
                }

                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { com.bayutb.core.data.Resource.Success(it) })
                }

                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(com.bayutb.core.data.Resource.Error(apiResponse.message))
                }
            }
        }
    }

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCall(data: RequestType)

    protected open fun onFetchFailed() {}

    fun asFlow() : Flow<com.bayutb.core.data.Resource<ResultType>> = result

}