package org.example.domain.models.store

import org.example.domain.models.shared.Name

class Store(
    val storeId: StoreId,
    val name: Name,
    val mainPhoneNumber: MainPhoneNumber,
    val storeBasicInfo: StoreBasicInfo?
) {
    companion object Factory {
        fun create(
            name: Name,
            mainPhoneNumber: MainPhoneNumber,
            storeBasicInfo: StoreBasicInfo? = null
        ): Store {
            return Store(
                storeId = StoreId.gen(),
                name = name,
                mainPhoneNumber = mainPhoneNumber,
                storeBasicInfo = storeBasicInfo
            )
        }
    }
}