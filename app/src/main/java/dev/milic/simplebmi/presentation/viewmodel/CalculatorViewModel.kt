package dev.milic.simplebmi.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.milic.simplebmi.domain.util.DataStoreManager
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class CalculatorViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    private val dataStoreManager: DataStoreManager = DataStoreManager(context = context)

    private val _ageCounter = MutableLiveData<Int>(20)
    val ageCounter: LiveData<Int> = _ageCounter

    private val _weightCounter = MutableLiveData<Int>(70)
    val weightCounter: LiveData<Int> = _weightCounter

    private val _heightCounter = MutableLiveData<Int>(150)
    val heightCounter: LiveData<Int> = _heightCounter

    private val _isFemaleIconSelected = MutableLiveData<Boolean>(true)
    val isFemaleIconSelected: LiveData<Boolean> = _isFemaleIconSelected

    private val _isMaleIconSelected = MutableLiveData<Boolean>(false)
    val isMaleIconSelected: LiveData<Boolean> = _isMaleIconSelected

    val unitChecked = dataStoreManager.getSelectedUnit()

    fun increaseAge() {
        _ageCounter.value?.let { age ->
            if (age in 1..999) {
                _ageCounter.value = age + 1
            }
        }
    }

    fun decreaseAge() {
        _ageCounter.value?.let { age ->
            _ageCounter.value = age - 1
        }
    }

    fun increaseWeight() {
        _weightCounter.value?.let { weight ->
            _weightCounter.value = weight + 1
        }
    }

    fun decreaseWeight() {
        _weightCounter.value?.let { weight ->
            _weightCounter.value = weight - 1
        }
    }

    fun updateHeightCounter(value: Int) {
        _heightCounter.value = value
    }

    fun changeGenderCardState() {
        if (_isFemaleIconSelected.value == true && _isMaleIconSelected.value == false) {
            _isFemaleIconSelected.value = false
            _isMaleIconSelected.value = true
        } else if (_isFemaleIconSelected.value == false && _isMaleIconSelected.value == true) {
            _isFemaleIconSelected.value = true
            _isMaleIconSelected.value = false
        }
    }

    fun calculateBMI(): Double {
        return (_weightCounter.value!!.div(
            heightCounter.value!!.toDouble().times(heightCounter.value!!.toDouble())
        ))
            .times(10000)
    }

    fun saveSelectedUnit(unit: String){
        when (unit){
            "Metric" -> saveToPreferences(pref = 0)
            "Imperial" -> saveToPreferences(pref = 1)
        }
    }

    private fun saveToPreferences(pref: Int){
        GlobalScope.launch(Dispatchers.IO) {
            dataStoreManager.safeSelectedUnit(key = pref)
        }
    }
}