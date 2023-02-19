package org.example.domain.entities.shared

import de.huxhorn.sulky.ulid.ULID
import org.example.domain.exceptions.DomainException

abstract class ID(val value: String) {

    init {
        this.validateId(value)
    }

    private fun validateId(id: String) {
        try {
            ULID.parseULID(id)
        } catch (ex: IllegalArgumentException) {
            throw DomainException("ULIDではない文字列が渡されました。")
        }
    }

    companion object {
        inline fun <reified T : ID> gen(): T {
            val ctor = T::class.java.getConstructor(String::class.java)
            return ctor.newInstance(ULID().nextValue().toString())
        }

        inline fun <reified T : ID> from(id: String): T {
            val ctor = T::class.java.getConstructor(String::class.java)
            return ctor.newInstance(id)
        }
    }
}