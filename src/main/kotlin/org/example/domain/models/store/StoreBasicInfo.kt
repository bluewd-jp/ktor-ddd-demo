package org.example.domain.models.store

import org.example.domain.exceptions.DomainException

class StoreBasicInfo(val value: String) {
    companion object {
        fun of(value: String): StoreBasicInfo {
            return StoreBasicInfo(value)
        }
    }

    init {
        this.validate(value)
    }

    private fun validate(value: String) {
        if (value.isBlank()) throw DomainException("店舗基本情報が空文字です。入力値:[${value}]")
    }
}
