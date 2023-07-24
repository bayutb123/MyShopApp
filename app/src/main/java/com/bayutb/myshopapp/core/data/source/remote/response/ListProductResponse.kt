package com.bayutb.myshopapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListProductResponse(

    @field:SerializedName("Response")
    val products: List<ProductResponse>
)

data class ProductResponse(

    @field:SerializedName("image")
    val image: String,

    @field:SerializedName("price")
    val price: Int,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String

)