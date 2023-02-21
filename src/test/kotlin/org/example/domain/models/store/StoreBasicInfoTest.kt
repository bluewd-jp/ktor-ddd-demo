package org.example.domain.models.store

import org.example.domain.exceptions.DomainException
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StoreBasicInfoTest {
    @Test
    fun of_RegularText_ShouldCreate() {
        val text = "店舗の基本情報"
        val storeBasicInfo = StoreBasicInfo(text)
        assertEquals(text, storeBasicInfo.value)
    }

    @Test
    fun of_EmptyOrBlankText_ExceptionThrown() {
        var text = ""
        var exception = assertFailsWith<DomainException> { StoreBasicInfo.of(text) }
        assertEquals("店舗基本情報が空文字です。入力値:[${text}]", exception.message)

        text = " "
        exception = assertFailsWith<DomainException> { StoreBasicInfo.of(text) }
        assertEquals("店舗基本情報が空文字です。入力値:[${text}]", exception.message)
    }
}