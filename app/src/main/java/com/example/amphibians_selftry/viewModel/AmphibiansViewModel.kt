package com.example.amphibians_selftry.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians_selftry.network.AmphibiansApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface AmphibiansUiState {
    data class Success(val amphibians: String) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}


class AmphibiansViewModel : ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                val listResult = AmphibiansApi.retrofitService.getAmphibians()
                AmphibiansUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
                )
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }

    }
}
