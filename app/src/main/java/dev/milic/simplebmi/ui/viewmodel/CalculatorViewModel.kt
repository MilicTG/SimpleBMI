package dev.milic.simplebmi.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    private val _ageCounter = MutableLiveData<Int>(20)
    val ageCounter: LiveData<Int> = _ageCounter

    private val _weightCounter = MutableLiveData<Int>(70)
    val weightCounter: LiveData<Int> = _weightCounter

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
}