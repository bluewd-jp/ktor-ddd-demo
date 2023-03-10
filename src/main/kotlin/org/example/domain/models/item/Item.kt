package org.example.domain.models.item

import org.example.domain.models.shared.Name

class Item(
    val itemId: ItemId,
    val name: Name,
    val price: Int
) {

    companion object Factory {
        fun create(
            name: Name,
            price: Int
        ): Item {
            return Item(
                itemId = ItemId.gen(),
                name = name,
                price = price
            )
        }

        fun reconstruct(
            itemId: ItemId,
            name: Name,
            price: Int
        ): Item {
            return Item(
                itemId = itemId,
                name = name,
                price = price
            )
        }
    }

}