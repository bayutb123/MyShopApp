package com.bayutb.myshopapp.favourite.screen.favourite

import com.bayutb.core.domain.usecase.ProductInteractor
import com.bayutb.core.domain.usecase.ProductUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModuleForFavouriteViewModel = module {
    factory<ProductUseCase> {
        ProductInteractor(get())
    }
}

val favouriteModule = module {
    viewModel { FavouriteViewModel(get()) }
}