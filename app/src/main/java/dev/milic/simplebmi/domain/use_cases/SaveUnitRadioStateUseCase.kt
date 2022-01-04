package dev.milic.simplebmi.domain.use_cases

import dev.milic.simplebmi.data.repository.Repository

class SaveUnitRadioStateUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(selected: Int) {
        repository.saveRadioUnitButtonState(selected = selected)
    }
}