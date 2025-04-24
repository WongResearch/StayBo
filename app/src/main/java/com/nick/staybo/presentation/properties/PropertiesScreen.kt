package com.nick.staybo.presentation.properties

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.nick.staybo.domain.model.Property

@Composable
fun PropertiesScreen(
    viewModel: PropertiesViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState

    Surface(modifier = modifier) {
        when (val state = uiState) {
            is PropertiesUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is PropertiesUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(state.message)
                        Button(
                            onClick = { viewModel.loadProperties() }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Retry"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Retry")
                        }
                    }
                }
            }
            is PropertiesUiState.Success -> {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    val property = state.properties.firstOrNull()
                    if (property != null) {
                        // Images
                        item {
                            if (property.images.isNotEmpty()) {
                                LazyRow(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    items(property.images) { imageUrl ->
                                        Card(
                                            modifier = Modifier
                                                .fillParentMaxHeight()
                                                .aspectRatio(1f)
                                        ) {
                                            SubcomposeAsyncImage(
                                                model = imageUrl,
                                                contentDescription = "Property image",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.fillMaxSize(),
                                                loading = {
                                                    Box(
                                                        modifier = Modifier.fillMaxSize(),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        CircularProgressIndicator()
                                                    }
                                                },
                                                error = {
                                                    Box(
                                                        modifier = Modifier.fillMaxSize(),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Icon(
                                                            imageVector = Icons.Default.Star,
                                                            contentDescription = "Error loading image",
                                                            tint = MaterialTheme.colorScheme.error
                                                        )
                                                    }
                                                }
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }

                        // Property Details
                        item {
                            PropertyCard(property = property)
                        }

                        // Check Availability Button
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = { /* TODO */ },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Add dates for prices")
                            }
                        }

                        // Featured Publications
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Featured in publications",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Designed by M4 Architecture",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        // Preview Amenities
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "What this place offers",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Column {
                                property.amenities.take(3).forEach { amenity ->
                                    Text(
                                        text = "• $amenity",
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.padding(vertical = 4.dp)
                                    )
                                }
                                if (property.amenities.size > 3) {
                                    TextButton(onClick = { /* TODO */ }) {
                                        Text("Show all ${property.amenities.size} amenities")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PropertyCard(property: Property) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = property.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${property.type} in ${property.location}",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Capacity"
                    )
                    Text(
                        text = "${property.capacity} guests · ${property.bedrooms} bedrooms · ${property.beds} beds",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating"
                )
                Text(
                    text = "${property.rating} (${property.reviewsCount} reviews)",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            HostSection(property.host)
        }
    }
}

@Composable
fun HostSection(host: com.nick.staybo.domain.model.Host) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hosted by ${host.name}",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
        if (host.isSuperhost) {
            Text(
                text = " · Superhost",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
    Text(
        text = "${host.experienceYears} years hosting experience",
        style = MaterialTheme.typography.bodyMedium
    )
}
