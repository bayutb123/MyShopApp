package com.bayutb.myshopapp.favourite.screen.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bayutb.core.domain.usecase.ProductUseCase

class FavouriteViewModel (productUseCase: ProductUseCase) : ViewModel(){
    val favouriteProduct = productUseCase.getFavouriteProduct().asLiveData()
}