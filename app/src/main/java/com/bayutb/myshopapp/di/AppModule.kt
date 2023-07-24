package com.bayutb.myshopapp.di

import com.bayutb.myshopapp.core.domain.usecase.ProductInteractor
import com.bayutb.myshopapp.core.domain.usecase.ProductUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideProductUseCase(productInteractor: ProductInteractor): ProductUseCase

}