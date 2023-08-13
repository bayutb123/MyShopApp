package com.bayutb.myshopapp.screen.detail

import androidx.lifecycle.ViewModel
import com.bayutb.core.domain.model.Product
import com.bayutb.core.domain.usecase.ProductUseCase

class DetailViewModel (private val productUseCase: ProductUseCase) : ViewModel() {
    fun setFavourite(product: Product, newStatus: Boolean) {

        productUseCase.setFavourite(product, newStatus)

    }

}