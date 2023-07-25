package com.bayutb.myshopapp

import android.app.Application
import com.bayutb.core.di.databaseModule
import com.bayutb.core.di.networkModule
import com.bayutb.core.di.repositoryModule
import com.bayutb.myshopapp.di.useCaseModule
import com.bayutb.myshopapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    useCaseModule,
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}