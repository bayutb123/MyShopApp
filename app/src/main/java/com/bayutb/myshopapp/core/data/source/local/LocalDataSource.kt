package com.bayutb.myshopapp.core.data.source.local

import com.bayutb.myshopapp.core.data.source.local.entity.ProductEntity
import com.bayutb.myshopapp.core.data.source.local.room.ProductDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: ProductDao) {

    fun getAllProduct() :Flow<List<ProductEntity>> = dao.getAllProduct()
    fun getFavouriteProduct() :Flow<List<ProductEntity>> = dao.getFavourite()
    suspend fun insertProduct(products: List<ProductEntity>) = dao.insertProduct(products)

    fun setFavourite(productEntity: ProductEntity, newState: Boolean) {
        productEntity.isFavourite = newState
        dao.updateFavourite(productEntity)
    }

}