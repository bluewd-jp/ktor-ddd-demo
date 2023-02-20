package org.example.domain.models.shared

import org.example.domain.exceptions.DomainException
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class NameTest {
    @Test
    fun of_NormalText_ShouldCreate() {
        val text = "name text"
        val name = Name.of(text)

        assertEquals(text, name.value)
    }

    @Test
    fun of_EmptyOrBlankText_ExceptionThrown() {
        val emptyText = ""
        val blankText = " "

        var throwable = assertFailsWith<DomainException> { Name.of(emptyText) }
        assertEquals("名前が空文字です。入力値:[${emptyText}]", throwable.message)

        throwable = assertFailsWith<DomainException> { Name.of(blankText) }
        assertEquals("名前が空文字です。入力値:[${blankText}]", throwable.message)
    }

    @Test
    fun of_50LengthText_ShouldCreate() {
        val text = "1234567890".repeat(5)
        val name = Name.of(text)
        assertEquals(text, name.value)
    }

    @Test
    fun of_Over50LengthText_ExceptionThrown() {
        val text = "1234567890".repeat(5) + "1"
        val throwable = assertFailsWith<DomainException> { Name.of(text) }

        assertEquals("名前の文字数が50文字を超えています。入力値:[${text}]", throwable.message)
    }
}