package com.example.pokex.di

import com.example.pokex.data.repository.DataRepository
import com.example.pokex.data.retrofit.repository.RetrofitRepository
import com.example.pokex.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRetrofitRepository():RetrofitRepository{
        return RetrofitRepository()
    }

    @Provides
    fun provideDataRepository(
         retrofitRepository: RetrofitRepository
    ):UserRepository{
        return DataRepository(
            retrofitRepository = retrofitRepository
        )
    }

}