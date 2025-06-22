package com.example.amphibians_selftry.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians_selftry.data.AmphibiansRepository
import com.example.amphibians_selftry.networking.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AmphibiansViewModel(
    private val repository: AmphibiansRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<AmphibiansUiState>(AmphibiansUiState.Loading)
    val uiState: StateFlow<AmphibiansUiState> = _uiState.asStateFlow()

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            _uiState.value = AmphibiansUiState.Loading

            repository.getAmphibians()
                .onSuccess { amphibians ->
                    _uiState.value = AmphibiansUiState.Success(amphibians)
                }
                .onFailure { error ->
                    _uiState.value = AmphibiansUiState.Error(error.message ?: "Unknown error")
                }
        }
    }
}

sealed class AmphibiansUiState {
    object Loading : AmphibiansUiState()
    data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState()
    data class Error(val message: String) : AmphibiansUiState()
}