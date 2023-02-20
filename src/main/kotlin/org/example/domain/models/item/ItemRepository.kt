package org.example.domain.models.item

interface ItemRepository {
    fun list(): List<Item>
}