package com.bayutb.myshopapp.core.domain.usecase

import com.bayutb.myshopapp.core.data.Resource
import com.bayutb.myshopapp.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {
    fun getAllProduct() : Flow<Resource<List<Product>>>
    fun getFavouriteProduct(): Flow<List<Product>>
    fun setFavourite(product: Product, state: Boolean)
}