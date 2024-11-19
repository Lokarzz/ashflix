package com.karlo.ashflix.ui.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karlo.ashflix.model.data.ashflix.login.LoginRequest
import com.karlo.ashflix.model.repository.main.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun updateUsername(username: String) {
        _uiState.value = _uiState.value.copy(userName = username)
    }

    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun login() {
        viewModelScope.launch {
            authRepository.login(
                LoginRequest(
                    _uiState.value.userName,
                    _uiState.value.password
                )
            ).catch {
                println(it)
            }.collect {
                println(it)
            }
        }
    }


}