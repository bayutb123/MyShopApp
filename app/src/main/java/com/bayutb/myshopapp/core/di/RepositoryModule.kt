package com.bayutb.myshopapp.core.di

import com.bayutb.myshopapp.core.data.ProductRepository
import com.bayutb.myshopapp.core.domain.repository.IProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(productRepository: ProductRepository): IProductRepository

}