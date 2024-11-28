package com.karlo.ashflix.utils.validation.password

import com.karlo.ashflix.utils.validation.InputValidation
import com.karlo.ashflix.utils.validation.Result

class PasswordValidation : InputValidation<String, PasswordValidation.Key> {

    override fun validate(input: String): List<Result<Key>> {
        return listOf(
            Result(valid = input.isNotBlank(), Key.EMPTY_PASSWORD)
        )
    }

    enum class Key {
        EMPTY_PASSWORD
    }
}