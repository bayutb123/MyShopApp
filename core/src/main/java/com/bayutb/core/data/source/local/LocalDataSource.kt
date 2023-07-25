package com.bayutb.core.data.source.local

import com.bayutb.core.data.source.local.entity.ProductEntity
import com.bayutb.core.data.source.local.room.ProductDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource (private val dao: ProductDao) {

    fun getAllProduct() :Flow<List<ProductEntity>> = dao.getAllProduct()
    fun getFavouriteProduct() :Flow<List<ProductEntity>> = dao.getFavourite()
    suspend fun insertProduct(products: List<ProductEntity>) = dao.insertProduct(products)

    fun setFavourite(productEntity: ProductEntity, newState: Boolean) {
        productEntity.isFavourite = newState
        dao.updateFavourite(productEntity)
    }

}