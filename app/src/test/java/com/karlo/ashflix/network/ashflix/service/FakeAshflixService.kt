package com.karlo.ashflix.network.ashflix.service

import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.model.data.ashflix.login.LoginResponse
import com.karlo.ashflix.model.network.ashflix.service.AshflixService
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

class FakeAshflixService : AshflixService {

    var loginResponse: LoginResponse? = null
    var hasNetwork = true

    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        if (loginRequest.userName == "") {
            throwHttpException<LoginResponse>(400, "User name must not be empty")
        }

        if (loginRequest.password == "") {
            throwHttpException<LoginResponse>(400, "Password is empty")
        }

        if (!hasNetwork) {
            throwHttpException<LoginResponse>(500, "Network Error")
        }

        return loginResponse ?: throw Exception("No Response set")
    }

    private fun <T> throwHttpException(code: Int, content: String) {
        throw HttpException(
            Response.error<T>(
                code,
                ResponseBody.create(MediaType.parse("application/json"), content)
            )
        )
    }
    companion object {
        private const val TAG  = "FakeAshflixService"
    }
}