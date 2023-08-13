package com.bayutb.core.domain.usecase

import com.bayutb.core.data.Resource
import com.bayutb.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {
    fun getAllProduct() : Flow<Resource<List<Product>>>
    fun getFavouriteProduct(): Flow<List<Product>>
    fun setFavourite(product: Product, state: Boolean)
}