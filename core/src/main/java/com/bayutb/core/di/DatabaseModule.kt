package com.bayutb.core.di

import androidx.room.Room
import com.bayutb.core.data.source.local.entity.ProductDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    factory { get<ProductDatabase>().dao() }
    single {
        val key : ByteArray = SQLiteDatabase.getBytes("mydb".toCharArray())
        val factory = SupportFactory(key)
        Room.databaseBuilder(
            androidContext(),
            ProductDatabase::class.java, "Product.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}