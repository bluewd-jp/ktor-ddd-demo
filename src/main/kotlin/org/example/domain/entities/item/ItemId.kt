package org.example.domain.entities.item

import org.example.domain.entities.shared.ID

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