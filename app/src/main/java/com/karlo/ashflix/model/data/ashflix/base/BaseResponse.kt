package com.karlo.ashflix.model.data.ashflix.base

data class BaseResponse<T>(
    val key: String,
    val data: T
)
