package com.karlo.ashflix.utils.validation.password

import com.karlo.ashflix.utils.validation.InputValidation
import com.karlo.ashflix.utils.validation.Key
import com.karlo.ashflix.utils.validation.Result

class PasswordValidation : InputValidation<String> {

    override fun validate(input: String): List<Result> {
        return listOf(
            Result(valid = input.isNotBlank(), DefaultKey.EMPTY_PASSWORD)
        )
    }

    enum class DefaultKey : Key {
        EMPTY_PASSWORD
    }
}