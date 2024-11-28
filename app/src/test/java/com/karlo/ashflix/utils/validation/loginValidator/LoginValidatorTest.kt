package com.karlo.ashflix.utils.validation.loginValidator

import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.utils.validation.InputValidation
import com.karlo.ashflix.utils.validation.Result
import com.karlo.ashflix.utils.validation.username.UserNameValidation
import org.junit.Before
import org.junit.Test


class LoginValidatorTest {

    private lateinit var loginValidator: InputValidation<LoginRequest, Any>

    @Before
    fun setUp() {
        loginValidator = LoginValidator()
    }

    @Test
    fun `validate login request with valid data`() {
        val loginRequest = LoginRequest(userName = "user", password = "password")

        val result = loginValidator.validate(loginRequest)

        val errorResults = result.filter { !it.valid }
        assert(errorResults.isEmpty())

    }

    @Test
    fun `validate login request with username errors`() {
        val loginRequest = LoginRequest(userName = "", password = "password")

        val result = loginValidator.validate(loginRequest)

        val errorResults = result.filter { !it.valid }

        assert(
            errorResults.contains(
                Result(
                    valid = false,
                    key = UserNameValidation.Key.EMPTY_USERNAME
                )
            )
        )
    }
}