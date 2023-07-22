package com.bayutb.myshopapp.core.di

import android.content.Context
import androidx.room.Room
import com.bayutb.myshopapp.core.source.local.entity.ProductDatabase
import com.bayutb.myshopapp.core.source.local.room.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java, "Product.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDao(database: ProductDatabase): ProductDao {
        return database.dao()
    }

}