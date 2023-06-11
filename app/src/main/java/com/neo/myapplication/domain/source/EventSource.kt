package com.neo.myapplication.domain.source

import com.neo.myapplication.data.remote.response.ResponseEventDetailData
import com.neo.myapplication.data.remote.response.ResponseEventListData

interface EventSource {

    suspend fun getEventListData(userIdx : Int) : Result<List<ResponseEventListData.ResponseEventListResult>>

    suspend fun getEventDetailData(eventIdx : Int) : Result<ResponseEventDetailData.ResponseEventDetailResult>
}