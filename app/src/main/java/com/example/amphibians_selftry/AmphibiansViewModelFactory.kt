package com.example.amphibians_selftry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.amphibians_selftry.data.AmphibiansRepository
import com.example.amphibians_selftry.viewModel.AmphibiansViewModel

class AmphibiansViewModelFactory(
    private val repository: AmphibiansRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AmphibiansViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AmphibiansViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}