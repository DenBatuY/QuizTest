package com.test.myapplication.presentation

import android.app.Application
import com.test.myapplication.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuizApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@QuizApp)
            modules(listOf(MainModule))
        }
    }
}