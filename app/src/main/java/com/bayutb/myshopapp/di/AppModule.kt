package com.bayutb.myshopapp.di

import com.bayutb.core.domain.usecase.ProductInteractor
import com.bayutb.core.domain.usecase.ProductUseCase
import com.bayutb.myshopapp.screen.detail.DetailViewModel
import com.bayutb.myshopapp.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<ProductUseCase> {
        ProductInteractor(get())
    }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}