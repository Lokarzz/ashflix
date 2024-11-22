package com.karlo.ashflix.ui.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.model.repository.main.auth.AuthRepository
import com.karlo.ashflix.ui.main.uiState.ApiState
import com.karlo.ashflix.utils.api.error.ErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun updateUsername(username: String) {
        _uiState.update {
            it.copy(
                userName = username
            )
        }
    }

    fun updatePassword(password: String) {
        _uiState.update {
            it.copy(
                password = password
            )
        }
    }

    fun login() {
        viewModelScope.launch {
            authRepository.login(
                LoginRequest(
                    _uiState.value.userName, _uiState.value.password
                )
            ).catch {
                _uiState.update { state ->
                    state.copy(
                        loginApiState = ApiState.Error(errorHandler.process(it))
                    )
                }
            }.onStart {
                _uiState.update { state ->
                    state.copy(
                        loginApiState = ApiState.Loading()
                    )
                }
            }.collect {
                _uiState.update { state ->
                    state.copy(
                        loginApiState = ApiState.Success(it)
                    )
                }
            }
        }
    }

    companion object {
        private const val TAG = "LoginViewModel"

    }
}