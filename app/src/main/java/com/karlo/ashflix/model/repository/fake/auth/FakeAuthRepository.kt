package com.karlo.ashflix.model.repository.fake.auth

import com.karlo.ashflix.model.data.ashflix.login.LoginData
import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.model.data.ashflix.login.LoginResponse
import com.karlo.ashflix.model.repository.main.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeAuthRepository : AuthRepository {

    override suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse> {
        return flow {
            emit(LoginResponse(key = "success", data = LoginData(token = "token")))
        }
    }
}