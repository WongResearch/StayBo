package com.nick.staybo.data.repository

import com.nick.staybo.domain.model.Property
import com.nick.staybo.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    // TODO: Add remote data source and local data source
) : PropertyRepository {
    override suspend fun getProperties(): Flow<List<Property>> {
        // TODO: Implement with actual data sources
        return flowOf(emptyList())
    }
}
