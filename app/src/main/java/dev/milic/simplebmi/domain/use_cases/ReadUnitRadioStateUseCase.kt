package dev.milic.simplebmi.domain.use_cases

import dev.milic.simplebmi.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadUnitRadioStateUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Int> {
        return repository.readRadioUnitButtonState()
    }
}