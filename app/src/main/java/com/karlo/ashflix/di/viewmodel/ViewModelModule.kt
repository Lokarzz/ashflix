package com.karlo.ashflix.di.viewmodel

import com.karlo.ashflix.model.repository.main.auth.AuthRepository
import com.karlo.ashflix.ui.view.login.DefaultLoginProvider
import com.karlo.ashflix.ui.view.login.LoginProvider
import com.karlo.ashflix.utils.api.error.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun providesLoginProvider(
        authRepository: AuthRepository,
        errorHandler: ErrorHandler
    ): LoginProvider {
        return DefaultLoginProvider(authRepository, errorHandler)
    }
}