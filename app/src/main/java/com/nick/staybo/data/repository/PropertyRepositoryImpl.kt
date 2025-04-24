package com.nick.staybo.data.repository

import com.nick.staybo.domain.model.Host
import com.nick.staybo.domain.model.Property
import com.nick.staybo.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    // TODO: Add remote data source and local data source
) : PropertyRepository {
    override suspend fun getProperties(): Flow<List<Property>> {
        // Mock data based on design doc
        val mockProperty = Property(
            id = "1",
            name = "MICA - Panoramic view close to Quebec City",
            location = "Lac-Beauport, Canada",
            type = "Tiny Home",
            capacity = 4,
            bedrooms = 2,
            beds = 4,
            rating = 4.99,
            reviewsCount = 275,
            host = Host(
                name = "Nicolas",
                isSuperhost = true,
                experienceYears = 3
            ),
            amenities = listOf(
                "Mountain view",
                "Valley view",
                "Kitchen",
                "Wi-Fi",
                "Dedicated workspace"
            ),
            images = listOf(
                "https://images.unsplash.com/photo-1518780664697-55e3ad937233?q=80&w=800",
                "https://images.unsplash.com/photo-1449158743715-0a90ebb6d2d8?q=80&w=800",
                "https://images.unsplash.com/photo-1464146072230-91cabc968266?q=80&w=800"
            )
        )

        return flowOf(listOf(mockProperty))
    }
}
