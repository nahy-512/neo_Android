package com.neo.myapplication.domain.source

import com.neo.myapplication.data.remote.response.ResponseLocationData

interface LocationSource {

    suspend fun getLocationSearch(query : String) : Result<List<ResponseLocationData.LocationData>>
}