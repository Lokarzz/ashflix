package com.karlo.ashflix.ui.main.provider

import com.karlo.ashflix.utils.api.error.ErrorHandler

interface ErrorProvider {
    val errorHandler : ErrorHandler
}