package com.neo.myapplication.data.remote.repository

import com.neo.myapplication.data.remote.response.ResponseLocationData
import com.neo.myapplication.domain.repository.LocationRepository
import com.neo.myapplication.domain.source.LocationSource
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(private val source : LocationSource): LocationRepository {
    override suspend fun getLocationSearch(query: String): Result<List<ResponseLocationData.LocationData>> {
        return source.getLocationSearch(query)
    }
}