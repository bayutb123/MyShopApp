package com.bayutb.myshopapp.core.source.remote.network

import com.bayutb.myshopapp.core.source.remote.response.ListProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts() : ListProductResponse
}