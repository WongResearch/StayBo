package com.nick.staybo.presentation.properties

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PropertiesScreen(
    viewModel: PropertiesViewModel = hiltViewModel()
) {
    val properties by viewModel.properties

    Surface {
        LazyColumn {
            items(properties) { property ->
                Text(text = property.toString())
            }
        }
    }
}
