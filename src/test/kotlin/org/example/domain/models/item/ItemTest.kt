package org.example.domain.models.item

import org.example.domain.models.shared.Name
import kotlin.test.Test
import kotlin.test.assertEquals

class ItemTest {
    @Test
    fun create_NormalParams_ShouldCreate() {
        val name = Name.of("item name")
        val price = 100

        val item = Item.create(name = name, price = price)
        assertEquals(name, item.name)
        assertEquals(price, item.price)
    }
}