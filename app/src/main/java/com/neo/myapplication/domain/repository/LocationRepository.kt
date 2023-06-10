package com.neo.myapplication.domain.repository

import com.neo.myapplication.data.remote.response.ResponseLocationData

interface LocationRepository {

    suspend fun getLocationSearch(query : String) : Result<List<ResponseLocationData.LocationData>>
}