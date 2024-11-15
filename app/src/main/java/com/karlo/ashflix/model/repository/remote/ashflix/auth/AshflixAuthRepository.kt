package com.karlo.ashflix.model.repository.remote.ashflix.auth

import com.karlo.ashflix.model.data.main.login.LoginRequest
import com.karlo.ashflix.model.data.main.login.LoginResponse
import com.karlo.ashflix.model.network.ashflix.service.AshflixService
import com.karlo.ashflix.model.repository.auth.AuthRepository
import com.karlo.ashflix.model.repository.remote.ashflix.auth.AuthExtension.toLoginResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AshflixAuthRepository(
    private val ashflixService: AshflixService
) : AuthRepository {


    override suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse> = flow {
        emit(ashflixService.login(loginRequest).toLoginResponse())
    }

}