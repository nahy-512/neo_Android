package com.neo.myapplication.data.remote.repository

import com.neo.myapplication.data.remote.response.ResponseReviewListData
import com.neo.myapplication.domain.repository.ReviewRepository
import com.neo.myapplication.domain.source.ReviewSource
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(private val source : ReviewSource): ReviewRepository {
    override suspend fun getReviewListData(eventIdx: Int): Result<List<ResponseReviewListData.ResponseReviewListResult>> {
        return source.getReviewListData(eventIdx)
    }
}