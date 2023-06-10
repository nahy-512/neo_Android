package com.neo.myapplication.data.remote.service

import com.neo.myapplication.data.remote.response.ResponseEventDetailData
import com.neo.myapplication.data.remote.response.ResponseEventListData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EventService {

    @GET("/events/{userIdx}")
    suspend fun getEventListData(
        @Path("userIdx") userIdx : Int
    ) : Response<ResponseEventListData>

    @GET("/events/userIdx/{eventIdx}")
    suspend fun getEventDetailData(
        @Path("eventIdx") eventIdx : Int
    ) : Response<ResponseEventDetailData>
}