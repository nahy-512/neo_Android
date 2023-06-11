package com.neo.myapplication.data.remote.source

import com.neo.myapplication.data.remote.response.ResponseReviewListData
import com.neo.myapplication.data.remote.service.ReviewService
import com.neo.myapplication.domain.source.ReviewSource
import javax.inject.Inject

class ReviewRemoteSource @Inject constructor(private val service : ReviewService): ReviewSource {
    override suspend fun getReviewListData(eventIdx: Int): Result<List<ResponseReviewListData.ResponseReviewListResult>> {
        val res = service.getEventReviewListData(eventIdx, 1)
        if(res.isSuccessful) {
            return Result.success(res.body()!!.result)
        }
        return Result.failure(IllegalArgumentException(res.message()))
    }
}