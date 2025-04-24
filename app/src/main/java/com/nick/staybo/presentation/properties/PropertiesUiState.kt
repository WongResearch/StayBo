package com.nick.staybo.presentation.properties

import com.nick.staybo.domain.model.Property

sealed interface PropertiesUiState {
    object Loading : PropertiesUiState
    data class Success(val properties: List<Property>) : PropertiesUiState
    data class Error(val message: String) : PropertiesUiState
}
