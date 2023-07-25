package com.bayutb.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class ProductEntity(

    @PrimaryKey
    @ColumnInfo(name = "productId")
    val productId: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "price")
    val price: Int,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "isFavourite")
    var isFavourite: Boolean = false
)
