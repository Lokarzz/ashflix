package com.karlo.ashflix.di.util

import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.utils.api.error.DefaultErrorHandler
import com.karlo.ashflix.utils.api.error.ErrorHandler
import com.karlo.ashflix.utils.validation.InputValidation
import com.karlo.ashflix.utils.validation.loginValidator.LoginValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

    @Provides
    fun providesDefaultErrorHandler(): ErrorHandler {
        return DefaultErrorHandler()
    }

    @Provides
    fun providesLoginValidator(): InputValidation<LoginRequest> {
        return LoginValidator()
    }

}