package org.example.domain.models.store

import org.example.domain.models.shared.ID

class StoreId(value: String) : ID(value) {
    companion object {
        fun gen(): StoreId {
            return ID.gen()
        }

        fun from(id: String): StoreId {
            return ID.from(id)
        }
    }
}