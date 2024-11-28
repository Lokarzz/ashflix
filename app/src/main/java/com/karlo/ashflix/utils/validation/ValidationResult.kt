package com.karlo.ashflix.utils.validation


data class Result<out T>(
    val valid: Boolean,
    val key: T,
)


