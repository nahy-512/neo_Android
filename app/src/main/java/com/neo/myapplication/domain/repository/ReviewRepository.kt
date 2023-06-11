package com.neo.myapplication.domain.repository

import com.neo.myapplication.data.remote.response.ResponseReviewListData

interface ReviewRepository {

    suspend fun getReviewListData(eventIdx : Int) : Result<List<ResponseReviewListData.ResponseReviewListResult>>
}