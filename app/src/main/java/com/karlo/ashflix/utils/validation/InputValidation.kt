package com.karlo.ashflix.utils.validation

interface InputValidation<in I, T> {
    fun validate(input: I): List<Result<T>>
}

