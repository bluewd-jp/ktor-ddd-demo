package org.example.domain.models.shared

import org.example.domain.exceptions.DomainException

class Name(val value: String) {
    companion object {
        const val MAX_LENGTH = 50

        fun of(value: String): Name {
            return Name(value)
        }
    }

    init {
        this.validateLength(value)
    }

    private fun validateLength(value: String) {
        if (value.isBlank()) throw DomainException("名前が空文字です。入力値:[${value}]")
        if (value.length > MAX_LENGTH) throw DomainException("名前の文字数が${MAX_LENGTH}文字を超えています。入力値:[$value]")
    }
}