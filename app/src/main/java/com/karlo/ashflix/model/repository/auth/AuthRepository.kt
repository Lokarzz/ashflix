package com.karlo.ashflix.model.repository.auth

import com.karlo.ashflix.model.data.main.login.LoginRequest
import com.karlo.ashflix.model.data.main.login.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse>

}