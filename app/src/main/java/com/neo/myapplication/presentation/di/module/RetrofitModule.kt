package com.neo.myapplication.presentation.di.module

import com.chunbae.narchive.presentation.di.annotation.KakaoRetrofit
import com.chunbae.narchive.presentation.di.annotation.moilRetrofit
import com.neo.myapplication.presentation.util.XAccessTokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    companion object {
        val KAKAO_URL = "https://dapi.kakao.com/"
        val MOIL_URL = "http://umcpractice.shop:8007"
    }

    @Provides
    @Singleton
    fun provideOkHttpInterceptor(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    @moilRetrofit
    fun provideMoilRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MOIL_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
    @Provides
    @Singleton
    @KakaoRetrofit
    fun provideKakaoRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(KAKAO_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

}