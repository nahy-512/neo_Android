package com.neo.myapplication.data.remote.source

import android.util.Log
import com.neo.myapplication.BuildConfig
import com.neo.myapplication.data.remote.response.ResponseLocationData
import com.neo.myapplication.data.remote.service.LocationService
import com.neo.myapplication.domain.source.LocationSource
import javax.inject.Inject

class LocationRemoteSource @Inject constructor(private val service : LocationService): LocationSource {
    override suspend fun getLocationSearch(query: String): Result<List<ResponseLocationData.LocationData>> {
        val res = service.getLocationData("KakaoAK 92b38149e00305e9c24284597df625f3", query)
        if(res.isSuccessful) {
            return Result.success(res.body()!!.documents)
        }
        return Result.failure(IllegalArgumentException(res.message()))
    }
}