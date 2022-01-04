package dev.milic.simplebmi.data.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreRadioUnitOperations: DataStoreRadioUnitOperations
) {

    suspend fun saveRadioUnitButtonState(selected: Int) {
        dataStoreRadioUnitOperations.saveRadioUnitButtonState(selected = selected)
    }

    fun readRadioUnitButtonState(): Flow<Int> {
        return dataStoreRadioUnitOperations.readRadioUnitButtonState()
    }
}