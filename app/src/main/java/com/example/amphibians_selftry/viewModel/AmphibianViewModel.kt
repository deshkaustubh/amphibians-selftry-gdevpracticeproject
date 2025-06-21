package com.example.amphibians_selftry.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians_selftry.data.AmphibiansRepository
import com.example.amphibians_selftry.networking.Amphibians
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AmphibianUiState {
    data class Success(val photos: List<Amphibians>) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}

class AmphibianViewModel(private val amphibiansRepository: AmphibiansRepository) : ViewModel() {

    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibians()
    }

   fun getAmphibians() {
       viewModelScope.launch {
           amphibianUiState = AmphibianUiState.Loading
           amphibianUiState = try {
               val result = amphibiansRepository.getAmphibians()[0]
               AmphibianUiState.Success(amphibiansRepository.getAmphibians())
           } catch (e: IOException) {
               AmphibianUiState.Error
           } catch (e: HttpException) {
               AmphibianUiState.Error
           }
       }
    }
}