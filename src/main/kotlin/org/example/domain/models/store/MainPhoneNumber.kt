package org.example.domain.models.store

import org.example.domain.exceptions.DomainException

class MainPhoneNumber(val value: String) {
    companion object {
        const val MAX_LENGTH = 15 // E.164

        fun of(value: String): MainPhoneNumber {
            return MainPhoneNumber(value)
        }
    }

    init {
        this.validate(value)
    }

    private fun validate(value: String) {
        if (value.isBlank()) throw DomainException("電話番号が空文字です。入力値:[${value}]")
        if (value.length > MAX_LENGTH) throw DomainException("電話番号の文字数が${MAX_LENGTH}文字を超えています。入力値:[$value]")
        val regex = Regex("^\\+?\\d+-?\\d+-?\\d+(-\\d+)?$")
        if (!value.matches(regex)) throw DomainException("電話番号が不正です。入力値:[${value}]")
    }
}