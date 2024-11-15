package com.karlo.ashflix.model.repository.remote.ashflix.auth

import com.karlo.ashflix.model.data.ashflix.login.AshflixLoginResponse
import com.karlo.ashflix.model.data.main.login.LoginResponse


object AuthExtension {

    fun AshflixLoginResponse.toLoginResponse(): LoginResponse {
        return LoginResponse(token)
    }
}