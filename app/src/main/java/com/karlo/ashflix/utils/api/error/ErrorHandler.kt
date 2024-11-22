package com.karlo.ashflix.utils.api.error

import com.karlo.ashflix.model.data.main.api.error.ErrorInfo

interface ErrorHandler {
    fun process(cause: Throwable) : ErrorInfo
}