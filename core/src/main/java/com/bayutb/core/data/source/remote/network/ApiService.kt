package com.bayutb.core.data.source.remote.network

import com.bayutb.core.data.source.remote.response.ListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products?limit=50")
    suspend fun getAllProducts() : ListResponse

}