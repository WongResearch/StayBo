package com.nick.staybo.domain.model

data class Property(
    val id: String,
    val name: String,
    val location: String,
    val type: String,
    val capacity: Int,
    val bedrooms: Int,
    val beds: Int,
    val rating: Double,
    val reviewsCount: Int,
    val host: Host,
    val amenities: List<String>,
    val images: List<String>
)

data class Host(
    val name: String,
    val isSuperhost: Boolean,
    val experienceYears: Int
)
