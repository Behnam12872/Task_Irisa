package com.example.myapplication.di

import com.example.myapplication.data.repository.NewsRepository
import com.example.myapplication.data.repository.NewsRepositoryImpl
import com.example.myapplication.ui.screen.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<NewsRepository> { NewsRepositoryImpl() }

    viewModel {
        NewsViewModel(get())
    }
}