package com.test.myapplication.di

import com.test.myapplication.data.ApiFactory
import com.test.myapplication.data.RepositoryImpl
import com.test.myapplication.data.Service
import com.test.myapplication.domain.LoadQuestionsUseCase
import com.test.myapplication.domain.Repository
import com.test.myapplication.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val MainModule = module {
    single<Service> { ApiFactory.apiService }
    single<Repository> { RepositoryImpl(get()) }
    viewModelOf(::MainViewModel)

    factory { LoadQuestionsUseCase(get()) }
}