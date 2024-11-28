package com.karlo.ashflix.utils.validation.loginValidator

import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.utils.validation.Result
import com.karlo.ashflix.utils.validation.password.PasswordValidation
import com.karlo.ashflix.utils.validation.username.UserNameValidation

class LoginValidator(
    private val userNameValidation: UserNameValidation = UserNameValidation(),
    private val passwordValidation: PasswordValidation = PasswordValidation()
) {

    fun isValid(loginRequest: LoginRequest): List<Result<Any>> {
        val (username, password) = loginRequest

        val result =
            userNameValidation.validate(input = username) + passwordValidation.validate(input = password)

        return result
    }
}