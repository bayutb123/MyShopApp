package com.bayutb.myshopapp.core.source.remote

import android.util.Log
import com.bayutb.myshopapp.core.source.remote.network.ApiResponse
import com.bayutb.myshopapp.core.source.remote.network.ApiService
import com.bayutb.myshopapp.core.source.remote.response.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getProducts() : Flow<ApiResponse<List<ProductResponse>>> {
        return flow {
            try {
                val response = apiService.getAllProducts()
                val data = response.products
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.products))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}