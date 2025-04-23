package com.nick.staybo.domain.repository

import com.nick.staybo.domain.model.Property
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    suspend fun getProperties(): Flow<List<Property>>
}
