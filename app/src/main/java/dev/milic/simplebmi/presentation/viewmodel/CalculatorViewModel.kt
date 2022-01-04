package dev.milic.simplebmi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.milic.simplebmi.domain.use_cases.UseCases
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

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

    private val _unitSelectedState = MutableStateFlow(value = 0)
    val unitSelectedState: StateFlow<Int> = _unitSelectedState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _unitSelectedState.value =
                useCases.readUnitRadioStateUseCase().stateIn(viewModelScope).value
        }
    }

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

    fun saveUnitRadioSelectorState(selectedUnit: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (selectedUnit) {
                "Metric" -> useCases.saveUnitRadioStateUseCase(selected = 0)
                "Imperial" -> useCases.saveUnitRadioStateUseCase(selected = 1)
            }
        }
    }
}