package com.bayutb.core.data.source.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bayutb.core.data.source.local.room.ProductDao

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun dao(): ProductDao

}