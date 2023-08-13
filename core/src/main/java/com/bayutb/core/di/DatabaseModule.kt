package com.bayutb.core.di

import androidx.room.Room
import com.bayutb.core.data.source.local.entity.ProductDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    factory { get<ProductDatabase>().dao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ProductDatabase::class.java, "Product.db"
        ).fallbackToDestructiveMigration().build()
    }
}