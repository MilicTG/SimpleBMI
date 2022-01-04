package dev.milic.simplebmi.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dev.milic.simplebmi.domain.util.Constants.PREFERENCE_DATASTORE_KEY
import dev.milic.simplebmi.domain.util.Constants.PREFERENCE_DATASTORE_UNIT_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_DATASTORE_KEY)

class DataStoreOperationsImpl(context: Context) : DataStoreRadioUnitOperations {

    private object PreferencesKey {
        val unitKey = intPreferencesKey(name = PREFERENCE_DATASTORE_UNIT_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveRadioUnitButtonState(selected: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.unitKey] = selected
        }
    }

    override fun readRadioUnitButtonState(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val unitState = preferences[PreferencesKey.unitKey] ?: 0
                unitState
            }
    }

}