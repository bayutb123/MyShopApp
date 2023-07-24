package com.bayutb.myshopapp.core.data.source.remote

import android.util.Log
import com.bayutb.myshopapp.core.data.source.remote.network.ApiResponse
import com.bayutb.myshopapp.core.data.source.remote.network.ApiService
import com.bayutb.myshopapp.core.data.source.remote.response.ProductResponse
import com.bayutb.myshopapp.core.domain.model.Product
import com.google.gson.GsonBuilder
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
                val data = response.response
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.response))
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