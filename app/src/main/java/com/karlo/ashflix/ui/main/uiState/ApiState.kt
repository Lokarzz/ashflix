package com.karlo.ashflix.ui.main.uiState

import com.karlo.ashflix.model.data.main.api.error.ErrorInfo

sealed class ApiState<T> {
    class Idle<T> : ApiState<T>()
    class Loading<T> : ApiState<T>()
    data class Success<T>(val response: T) : ApiState<T>()
    class Error<T>(val errorInfo: ErrorInfo) : ApiState<T>()
}





