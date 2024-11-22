package com.karlo.ashflix.utils.api.error

import com.karlo.ashflix.model.data.main.api.error.ErrorInfo
import retrofit2.HttpException

class DefaultErrorHandler : ErrorHandler {

    override fun process(cause: Throwable): ErrorInfo {
        val message: String
        val code: Int
        when (cause) {
            is HttpException -> {
                message = cause.response()?.errorBody()?.string() ?: ""
                code = cause.code()
            }

            else -> {
                message = cause.message ?: ""
                code = 0
            }
        }
        return ErrorInfo(
            message = message,
            code = code
        )
    }
}