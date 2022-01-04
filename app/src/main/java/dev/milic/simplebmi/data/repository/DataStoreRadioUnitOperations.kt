package dev.milic.simplebmi.data.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRadioUnitOperations {
    suspend fun saveRadioUnitButtonState(selected: Int)
    fun readRadioUnitButtonState(): Flow<Int>
}