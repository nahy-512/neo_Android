package com.neo.myapplication.presentation.di.module

import com.neo.myapplication.data.remote.repository.EventRepositoryImpl
import com.neo.myapplication.data.remote.repository.LocationRepositoryImpl
import com.neo.myapplication.domain.repository.EventRepository
import com.neo.myapplication.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLocationRepository(locationRepositoryImpl: LocationRepositoryImpl) : LocationRepository

    @Binds
    abstract fun bindEventRepository(eventRepositoryImpl: EventRepositoryImpl) : EventRepository
}