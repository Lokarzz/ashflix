package com.karlo.ashflix.utils.validation

interface InputValidation<T> {
    fun validate(input: String): List<Result<T>>
}

