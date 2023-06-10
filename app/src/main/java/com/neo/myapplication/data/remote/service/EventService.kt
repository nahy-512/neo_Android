package com.neo.myapplication.data.remote.service

import com.neo.myapplication.data.remote.response.ResponseEventListData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EventService {

    @GET("/events/{userIdx}")
    suspend fun getEventListData(
        @Path("userIdx") userIdx : Int
    ) : Response<ResponseEventListData>
}