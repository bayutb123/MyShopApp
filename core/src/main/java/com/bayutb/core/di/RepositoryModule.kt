package com.bayutb.core.di

import com.bayutb.core.data.ProductRepository
import com.bayutb.core.data.source.local.LocalDataSource
import com.bayutb.core.data.source.remote.RemoteDataSource
import com.bayutb.core.domain.repository.IProductRepository
import com.bayutb.core.utils.MyExecutors
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { MyExecutors() }
    single<IProductRepository> {
        ProductRepository(get(), get(), get())
    }
}