package com.bayutb.core.data.source.remote

import android.util.Log
import com.bayutb.core.data.source.remote.network.ApiResponse
import com.bayutb.core.data.source.remote.network.ApiService
import com.bayutb.core.data.source.remote.response.ProductsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource (private val apiService: ApiService) {

    suspend fun getProducts() : Flow<ApiResponse<List<ProductsResponse>>> {
        return flow {
            try {
                val response = apiService.getAllProducts()
                val data = response.products
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.products))
                    Log.d("RemoteDataSource", data.toString())
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