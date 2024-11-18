package com.karlo.ashflix.model.network.ashflix.service

import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.model.data.ashflix.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AshflixService {

    @POST("ashflix/authenticate/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}