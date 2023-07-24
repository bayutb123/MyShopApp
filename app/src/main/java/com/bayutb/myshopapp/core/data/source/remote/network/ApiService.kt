package com.bayutb.myshopapp.core.data.source.remote.network

import com.bayutb.myshopapp.core.data.source.remote.response.ListProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts() : ListProductResponse
}