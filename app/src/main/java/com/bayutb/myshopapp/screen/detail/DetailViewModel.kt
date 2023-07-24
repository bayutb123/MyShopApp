package com.bayutb.myshopapp.screen.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bayutb.myshopapp.core.domain.model.Product
import com.bayutb.myshopapp.core.domain.usecase.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val productUseCase: ProductUseCase) : ViewModel() {
    fun setFavourite(product: Product, newStatus: Boolean) {

        Log.d("Status", newStatus.toString())
        productUseCase.setFavourite(product, newStatus)

    }

}