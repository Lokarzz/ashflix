package com.karlo.ashflix.ui.view.login

import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.model.repository.fake.auth.FakeAuthRepository
import com.karlo.ashflix.model.repository.main.auth.AuthRepository
import com.karlo.ashflix.ui.main.provider.ErrorProvider
import com.karlo.ashflix.utils.api.error.DefaultErrorHandler
import com.karlo.ashflix.utils.api.error.ErrorHandler
import com.karlo.ashflix.utils.validation.InputValidation
import com.karlo.ashflix.utils.validation.loginValidator.LoginValidator


interface LoginProvider : ErrorProvider {
    val authRepository: AuthRepository
    val loginValidator: InputValidation<LoginRequest>
}

class DefaultLoginProvider(
    override val authRepository: AuthRepository,
    override val errorHandler: ErrorHandler,
    override val loginValidator: InputValidation<LoginRequest>,
    ) : LoginProvider

// for testing and compose previews
class FakeLoginProvider(
    override val authRepository: AuthRepository = FakeAuthRepository(),
    override val errorHandler: ErrorHandler = DefaultErrorHandler(),
    override val loginValidator: InputValidation<LoginRequest> = LoginValidator(),
) : LoginProvider