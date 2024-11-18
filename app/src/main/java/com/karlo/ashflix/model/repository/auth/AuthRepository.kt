package com.karlo.ashflix.model.repository.auth

import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.model.data.ashflix.login.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse>

}