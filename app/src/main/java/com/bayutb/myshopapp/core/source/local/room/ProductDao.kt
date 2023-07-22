package com.bayutb.myshopapp.core.source.local.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bayutb.myshopapp.core.source.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductDao {

    @Query("SELECT * FROM Products")
    fun getAllProduct(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM Products WHERE isFavourite=1")
    fun getFavourite(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: List<ProductEntity>)

    @Update
    fun updateFavourite(productEntity: ProductEntity)

}