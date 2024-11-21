package com.karlo.ashflix.ui.view.login

import com.karlo.ashflix.model.data.ashflix.login.LoginResponse
import com.karlo.ashflix.ui.main.uiState.ApiState

data class LoginUiState(
    var userName: String = "",
    var password: String = "",
    var loginApiState: ApiState<LoginResponse> = ApiState.Idle()
)


