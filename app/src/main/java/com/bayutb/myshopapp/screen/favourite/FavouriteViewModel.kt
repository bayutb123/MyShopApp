package com.bayutb.myshopapp.screen.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bayutb.myshopapp.core.domain.usecase.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(productUseCase: ProductUseCase) : ViewModel(){
    val favouriteProduct = productUseCase.getFavouriteProduct().asLiveData()
}