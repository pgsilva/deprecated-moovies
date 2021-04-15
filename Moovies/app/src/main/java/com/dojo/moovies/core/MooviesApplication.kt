package com.dojo.moovies.core

import android.app.Application
import com.dojo.moovies.di.apiModules
import com.dojo.moovies.di.searchModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MooviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MooviesApplication)

            modules(
                //add Modules for Koin
                apiModules,
                searchModule
            )
        }
    }
}