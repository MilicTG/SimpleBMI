package dev.milic.simplebmi.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dev.milic.simplebmi.util.Constants.BMI_DATASTORE
import kotlinx.coroutines.flow.map

class DataStoreManager(val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = BMI_DATASTORE)

    companion object {
        val SELECTED_UNIT = intPreferencesKey("UNIT")
    }

    suspend fun safeSelectedUnit(key: Int) {
        context.dataStore.edit {
            it[SELECTED_UNIT] = key
        }
    }

     fun getSelectedUnit() = context.dataStore.data.map { unit ->
        unit[SELECTED_UNIT] ?: 0
    }

}