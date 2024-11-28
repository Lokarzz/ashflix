package com.karlo.ashflix.utils.validation

interface InputValidation<I> {
    fun validate(input: I): List<Result>
}

