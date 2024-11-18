package com.karlo.ashflix.model.di.network

import com.karlo.ashflix.model.network.ashflix.service.AshflixService
import com.karlo.ashflix.model.repository.auth.AuthRepository
import com.karlo.ashflix.model.repository.remote.ashflix.auth.AshflixAuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    @Singleton
    @Provides
    fun providesAshflixRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ashlix-be.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun providesAshflixService(retrofit: Retrofit): AshflixService {
        return retrofit.create(AshflixService::class.java)
    }

    @Singleton
    @Provides
    fun providesAshflixAuthRepository(ashflixService: AshflixService): AuthRepository {
        return AshflixAuthRepository(ashflixService)
    }

}