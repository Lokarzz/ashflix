package com.karlo.ashflix.model.data.ashflix.login

import com.karlo.ashflix.model.data.main.login.LoginRequest

data class AshflixLoginRequest(
    val userName: String,
    val password: String
) : LoginRequest