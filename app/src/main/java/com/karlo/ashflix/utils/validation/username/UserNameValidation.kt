package com.karlo.ashflix.utils.validation.username

import com.karlo.ashflix.utils.validation.InputValidation
import com.karlo.ashflix.utils.validation.Result
import com.karlo.ashflix.utils.validation.Constants

class UserNameValidation : InputValidation<UserNameValidation.Key> {

    override fun validate(input: String): List<Result<Key>> {
        return listOf(
            Result(valid = input.isNotBlank(), key = Key.EMPTY_USERNAME),
            Result(valid = input.noSpecialCharacter(), key = Key.HAS_SPECIAL_CHAR),
        )
    }

    private fun String.noSpecialCharacter(): Boolean {
        val usernamePattern = Constants.RegexPatterns.NO_SPECIAL_CHAR.toRegex()
        return usernamePattern.matches(this)
    }

    enum class Key {
        EMPTY_USERNAME, HAS_SPECIAL_CHAR
    }
}