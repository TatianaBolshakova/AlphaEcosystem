package com.example.alphaecosystem.di


import com.example.data.repository.RepositoryImpl
import com.example.domain.repository.Repository
import dagger.Module
import dagger.Provides


@Module
class DataModule {
    @Provides
    fun provideRepository(): Repository {
        return RepositoryImpl()
    }
}

