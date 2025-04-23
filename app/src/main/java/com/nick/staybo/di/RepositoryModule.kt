package com.nick.staybo.di

import com.nick.staybo.data.repository.PropertyRepositoryImpl
import com.nick.staybo.domain.repository.PropertyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPropertyRepository(
        propertyRepositoryImpl: PropertyRepositoryImpl
    ): PropertyRepository
}
