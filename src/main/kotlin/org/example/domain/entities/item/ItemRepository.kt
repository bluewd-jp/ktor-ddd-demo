package org.example.domain.entities.item

interface ItemRepository {
    fun list(): List<Item>
}