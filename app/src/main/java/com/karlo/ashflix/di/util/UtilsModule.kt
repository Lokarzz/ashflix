package com.karlo.ashflix.di.util

import com.karlo.ashflix.model.network.ashflix.service.AshflixService
import com.karlo.ashflix.model.repository.main.auth.AuthRepository
import com.karlo.ashflix.model.repository.remote.ashflix.auth.AshflixAuthRepository
import com.karlo.ashflix.utils.api.error.DefaultErrorHandler
import com.karlo.ashflix.utils.api.error.ErrorHandler
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
object UtilsModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): ErrorHandler {
        return DefaultErrorHandler()
    }

}