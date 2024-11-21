package com.karlo.ashflix.ui.main.uiState

sealed class ApiState<T> {
    class Idle<T> : ApiState<T>()
    class Loading<T> : ApiState<T>()
    data class Success<T>(val response: T) : ApiState<T>()
    data class Error<T>(val message: String?, val code: Int) : ApiState<T>()
}

