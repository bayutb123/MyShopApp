package com.bayutb.myshopapp.core.source.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bayutb.myshopapp.core.source.local.room.ProductDao

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun dao(): ProductDao

}