package org.example.domain.models.store

import org.example.domain.exceptions.DomainException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MainPhoneNumberTest {
    @Test
    fun of_DomesticPhoneNumberWithDash_ShouldCreate() {
        val text = "1234-56-7890"
        val mainPhoneNumber = MainPhoneNumber.of(text)
        assertEquals(text, mainPhoneNumber.value)
    }

    @Test
    fun of_DomesticPhoneNumberNoDash_ShouldCreate() {
        val text = "1234567890"
        val mainPhoneNumber = MainPhoneNumber.of(text)
        assertEquals(text, mainPhoneNumber.value)
    }

    @Test
    fun of_E164PhoneNumber15Length_ShouldCreate() {
        val text = "+81-1-2345-6789"
        val mainPhoneNumber = MainPhoneNumber.of(text)
        assertEquals(text, mainPhoneNumber.value)
    }

    @Test
    fun of_EmptyOrBlankPhoneNumber_ExceptionThrown() {
        var text = ""
        var exception = assertFailsWith<DomainException> { MainPhoneNumber.of(text) }
        assertEquals("電話番号が空文字です。入力値:[${text}]", exception.message)

        text = " "
        exception = assertFailsWith<DomainException> { MainPhoneNumber.of(text) }
        assertEquals("電話番号が空文字です。入力値:[${text}]", exception.message)
    }

    @Test
    fun of_Over15LengthPhoneNumber_ExceptionThrown() {
        val text = "1234567890123456"
        val exception = assertFailsWith<DomainException> { MainPhoneNumber.of(text) }
        assertEquals("電話番号の文字数が15文字を超えています。入力値:[$text]", exception.message)
    }

    @Test
    fun of_PhoneNumberWithDashPrefix_ExceptionThrown() {
        val text = "-123-45-6789"
        val exception = assertFailsWith<DomainException> { MainPhoneNumber.of(text) }
        assertEquals("電話番号が不正です。入力値:[${text}]", exception.message)
    }

    @Test
    fun of_PhoneNumberWithDashSuffix_ExceptionThrown() {
        val text = "1234-56-789-"
        val exception = assertFailsWith<DomainException> { MainPhoneNumber.of(text) }
        assertEquals("電話番号が不正です。入力値:[${text}]", exception.message)
    }
}