package com.neo.myapplication.domain.repository

import com.neo.myapplication.data.remote.response.ResponseEventDetailData
import com.neo.myapplication.data.remote.response.ResponseEventListData

interface EventRepository {

    suspend fun getEventListData(userIdx : Int) : Result<List<ResponseEventListData.ResponseEventListResult>>

    suspend fun getEventDetailData(eventIdx : Int) : Result<ResponseEventDetailData.ResponseEventDetailResult>
}