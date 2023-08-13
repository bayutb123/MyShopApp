package com.bayutb.myshopapp.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bayutb.core.domain.usecase.ProductUseCase

class HomeViewModel (productUseCase: ProductUseCase) : ViewModel(){
    val products = productUseCase.getAllProduct().asLiveData()
}