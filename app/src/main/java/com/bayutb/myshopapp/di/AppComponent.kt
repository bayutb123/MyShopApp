package com.bayutb.myshopapp.di

import android.content.Context
import com.bayutb.myshopapp.screen.home.HomeActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: HomeActivity)

}