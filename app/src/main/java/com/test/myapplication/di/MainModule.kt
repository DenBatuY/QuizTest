package com.test.myapplication.di

import com.test.myapplication.data.ApiFactory
import com.test.myapplication.data.Service
import org.koin.dsl.module

val MainModule = module {
    single<Service> { ApiFactory.apiService }
}