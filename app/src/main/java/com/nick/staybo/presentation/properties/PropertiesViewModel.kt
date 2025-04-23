package com.nick.staybo.presentation.properties

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.staybo.domain.model.Property
import com.nick.staybo.domain.usecase.GetPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertiesViewModel @Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModel() {
    private val _properties = mutableStateOf<List<Property>>(emptyList())
    val properties: State<List<Property>> = _properties

    init {
        loadProperties()
    }

    private fun loadProperties() {
        viewModelScope.launch {
            getPropertiesUseCase()
                .onEach { properties ->
                    _properties.value = properties
                }
                .launchIn(viewModelScope)
        }
    }
}
