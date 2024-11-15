package com.karlo.ashflix.model.di.network

import com.karlo.ashflix.model.network.ashflix.service.AshflixService
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
    @Named("AshflixRetrofit")
    fun providesAshflixRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return createRetrofitInstance("https://ashlix-be.onrender.com/", okHttpClient)
    }

    @Singleton
    @Provides
    @Named("CatflixRetrofit")
    fun providesCatflixRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return createRetrofitInstance("https://catflix-be.onrender.com/", okHttpClient)
    }

    @Singleton
    @Provides
    fun providesAshflixService(@Named("AshflixRetrofit") retrofit: Retrofit): AshflixService {
        return retrofit.create(AshflixService::class.java)
    }


    private fun createRetrofitInstance(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}