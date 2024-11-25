package com.karlo.ashflix.ui.view.login

import androidx.lifecycle.SavedStateHandle
import com.karlo.ashflix.model.repository.fake.auth.FakeAuthRepository
import com.karlo.ashflix.model.repository.main.auth.AuthRepository
import com.karlo.ashflix.ui.main.provider.ErrorProvider
import com.karlo.ashflix.utils.api.error.DefaultErrorHandler
import com.karlo.ashflix.utils.api.error.ErrorHandler


interface LoginProvider : ErrorProvider {
    val authRepository: AuthRepository
    val savedStateHandle : SavedStateHandle
}

class DefaultLoginProvider(
    override val authRepository: AuthRepository,
    override val errorHandler: ErrorHandler, override val savedStateHandle: SavedStateHandle
) : LoginProvider

// for testing and compose previews
class FakeLoginProvider(
    override val authRepository: AuthRepository = FakeAuthRepository(),
    override val errorHandler: ErrorHandler = DefaultErrorHandler(),
    override val savedStateHandle: SavedStateHandle
) : LoginProvider