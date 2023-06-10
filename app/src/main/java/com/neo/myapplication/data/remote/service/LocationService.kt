package com.neo.myapplication.data.remote.service

import com.neo.myapplication.data.remote.response.ResponseLocationData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LocationService {
    @GET("/v2/local/search/keyword.json")
    suspend fun getLocationData(
        @Header("Authorization") authorization : String,
        @Query("query", encoded = true) query : String
    ) : Response<ResponseLocationData>

}