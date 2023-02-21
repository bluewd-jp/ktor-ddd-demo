package org.example.domain.models.store

import org.example.domain.models.shared.Name
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class StoreTest {
    @Test
    fun create_RegularParams_ShouldCreate() {
        val name = Name.of("店舗名")
        val mainPhoneNumber = MainPhoneNumber.of("12-3456-7890")
        val storeBasicInfo = StoreBasicInfo.of("店舗基本情報")

        val store = Store.create(
            name = name,
            mainPhoneNumber = mainPhoneNumber,
            storeBasicInfo = storeBasicInfo
        )
        assertEquals(name, store.name)
        assertEquals(mainPhoneNumber, store.mainPhoneNumber)
        assertEquals(storeBasicInfo, store.storeBasicInfo)
    }

    @Test
    fun create_NoStoreBasicInfoParams_ShouldCreate() {
        val name = Name.of("店舗名")
        val mainPhoneNumber = MainPhoneNumber.of("12-3456-7890")

        val store = Store.create(
            name = name,
            mainPhoneNumber = mainPhoneNumber
        )
        assertEquals(name, store.name)
        assertEquals(mainPhoneNumber, store.mainPhoneNumber)
        assertNull(store.storeBasicInfo)
    }
}