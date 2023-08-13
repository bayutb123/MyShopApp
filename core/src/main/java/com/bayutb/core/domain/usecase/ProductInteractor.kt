package com.bayutb.core.domain.usecase

import com.bayutb.core.domain.model.Product
import com.bayutb.core.domain.repository.IProductRepository

class ProductInteractor (private val productRepository: IProductRepository) :
    ProductUseCase {

    override fun getAllProduct() = productRepository.getAllProduct()

    override fun getFavouriteProduct() = productRepository.getFavouriteProduct()

    override fun setFavourite(product: Product, state: Boolean) = productRepository.setFavourite(product, state)

}