package com.neo.myapplication.presentation.di.module

import com.chunbae.narchive.presentation.di.annotation.KakaoRetrofit
import com.neo.myapplication.data.remote.service.LocationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideLocationService(@KakaoRetrofit retrofit: Retrofit): LocationService = retrofit.create(LocationService::class.java)
}