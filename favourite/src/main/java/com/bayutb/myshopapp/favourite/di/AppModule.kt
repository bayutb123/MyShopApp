package com.bayutb.myshopapp.favourite.di

import com.bayutb.myshopapp.favourite.screen.favourite.FavouriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favouriteModule = module {
    viewModel { FavouriteViewModel(get()) }
}