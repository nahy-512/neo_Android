package com.neo.myapplication.data.remote.service

import com.neo.myapplication.data.remote.response.ResponseReviewListData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ReviewService {

    @GET("/reviews")
    suspend fun getEventReviewListData(
        @Query("eventIdx") eventIdx : Int,
        @Query("userIdx") userIdx : Int
    ) : Response<ResponseReviewListData>
}