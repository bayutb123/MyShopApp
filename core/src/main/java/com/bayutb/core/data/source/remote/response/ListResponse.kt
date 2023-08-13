package com.bayutb.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListResponse(

    @field:SerializedName("products")
    val products: List<ProductsResponse>
)

data class ProductsResponse(

    @field:SerializedName("thumbnail")
    val thumbnail: String,

    @field:SerializedName("price")
    val price: Int,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

)