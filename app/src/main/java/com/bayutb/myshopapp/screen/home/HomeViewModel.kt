package com.bayutb.myshopapp.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bayutb.myshopapp.core.domain.usecase.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(productUseCase: ProductUseCase) : ViewModel(){
    val products = productUseCase.getAllProduct().asLiveData()
}