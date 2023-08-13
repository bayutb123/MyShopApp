package com.bayutb.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bayutb.core.data.source.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM Products")
    fun getAllProduct(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM Products WHERE isFavourite=1")
    fun getFavourite(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: List<ProductEntity>)

    @Update
    fun updateFavourite(productEntity: ProductEntity)

}