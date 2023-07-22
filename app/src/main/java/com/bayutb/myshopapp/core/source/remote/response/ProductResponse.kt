package com.bayutb.myshopapp.core.source.remote.response

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @field:SerializedName("id")
    val id : Int,

    @field:SerializedName("title")
    val title : String,

    @field:SerializedName("description")
    val description : String,

    @field:SerializedName("price")
    val price : Int,

    @field:SerializedName("image")
    val image : String,

)