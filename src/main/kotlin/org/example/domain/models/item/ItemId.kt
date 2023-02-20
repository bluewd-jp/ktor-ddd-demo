package org.example.domain.models.item

import org.example.domain.models.shared.ID

class ItemId(value: String) : ID(value) {
    companion object Factory {
        fun gen(): ItemId {
            return ID.gen()
        }

        fun from(id: String): ItemId {
            return ID.from(id)
        }
    }
}