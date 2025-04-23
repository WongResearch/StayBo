package com.nick.staybo.domain.usecase

import com.nick.staybo.domain.model.Property
import com.nick.staybo.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPropertiesUseCase @Inject constructor(
    private val repository: PropertyRepository
) {
    suspend operator fun invoke(): Flow<List<Property>> = repository.getProperties()
}
