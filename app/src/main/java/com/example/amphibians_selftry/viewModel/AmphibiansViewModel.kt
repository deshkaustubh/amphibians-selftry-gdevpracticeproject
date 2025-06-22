package com.example.amphibians_selftry.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians_selftry.network.AmphibiansApi
import kotlinx.coroutines.launch
import retrofit2.http.GET
import java.io.IOException


sealed interface AmphibiansUiState {
    data class Success(val amphibians: String) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}


class AmphibiansViewModel : ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    @GET("amphibians")
    suspend fun getAmphibians() {
        viewModelScope.launch {
            try {
                val listResult = AmphibiansApi.retrofitService.getAmphibians()
                AmphibiansUiState.Success("Success: ${listResult.size} mars photos retrieved")
                // This AmphibiansApi is the object not the service directly called as we implemented earlier
            }catch (e: IOException) {
                AmphibiansUiState.Error
            }

        }
    }
}