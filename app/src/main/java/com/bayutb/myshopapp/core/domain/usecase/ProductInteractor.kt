package com.bayutb.myshopapp.core.domain.usecase

import com.bayutb.myshopapp.core.data.Resource
import com.bayutb.myshopapp.core.domain.model.Product
import com.bayutb.myshopapp.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductInteractor @Inject constructor(private val productRepository: IProductRepository) :
    ProductUseCase {

    override fun getAllProduct() = productRepository.getAllProduct()

    override fun getFavouriteProduct() = productRepository.getFavouriteProduct()

    override fun setFavourite(product: Product, state: Boolean) = productRepository.setFavourite(product, state)

}