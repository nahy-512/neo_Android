package com.neo.myapplication.domain.source

import com.neo.myapplication.data.remote.response.ResponseReviewListData

interface ReviewSource {

    suspend fun getReviewListData(eventIdx : Int) : Result<List<ResponseReviewListData.ResponseReviewListResult>>
}