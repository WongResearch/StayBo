package com.nick.staybo.presentation.properties

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.staybo.domain.model.Property
import com.nick.staybo.domain.usecase.GetPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertiesViewModel @Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModel() {
    private val _uiState = mutableStateOf<PropertiesUiState>(PropertiesUiState.Loading)
    val uiState: State<PropertiesUiState> = _uiState

    private var propertiesJob: Job? = null

    init {
        loadProperties()
    }

    fun loadProperties() {
        propertiesJob?.cancel()
        propertiesJob = viewModelScope.launch {
            try {
                _uiState.value = PropertiesUiState.Loading
                getPropertiesUseCase()
                    .catch { error ->
                        _uiState.value = PropertiesUiState.Error(
                            error.message ?: "Unknown error occurred"
                        )
                    }
                    .collect { properties ->
                        _uiState.value = PropertiesUiState.Success(properties)
                    }
            } catch (e: Exception) {
                _uiState.value = PropertiesUiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        propertiesJob?.cancel()
    }
}
