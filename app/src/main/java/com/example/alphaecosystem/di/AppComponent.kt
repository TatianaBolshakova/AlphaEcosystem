package com.example.alphaecosystem.di


import com.example.alphaecosystem.presentation.viewmodels.SearchViewModelFactory

import dagger.Component

@Component(modules = [DataModule::class])
interface AppComponent {
    fun searchViewModelFactory(): SearchViewModelFactory
}