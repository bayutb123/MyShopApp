package com.bayutb.myshopapp.screen.detail

import androidx.lifecycle.ViewModel
import com.bayutb.myshopapp.core.domain.model.Product
import com.bayutb.myshopapp.core.domain.usecase.ProductUseCase
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val productUseCase: ProductUseCase) : ViewModel() {
    fun setFavourite(product: Product, newStatus: Boolean) {
        productUseCase.setFavourite(product, newStatus)
    }
}