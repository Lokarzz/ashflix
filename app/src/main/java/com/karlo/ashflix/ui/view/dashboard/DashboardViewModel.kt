package com.karlo.ashflix.ui.view.dashboard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUIState())
    val uiState = _uiState.asStateFlow()


}