package com.neo.myapplication.data.remote.source

import com.neo.myapplication.data.remote.response.ResponseEventDetailData
import com.neo.myapplication.data.remote.response.ResponseEventListData
import com.neo.myapplication.data.remote.service.EventService
import com.neo.myapplication.domain.source.EventSource
import javax.inject.Inject

class EventRemoteSource @Inject constructor(private val service : EventService): EventSource {
    override suspend fun getEventListData(userIdx: Int): Result<List<ResponseEventListData.ResponseEventListResult>> {
        val res = service.getEventListData(userIdx)
        if(res.isSuccessful) {
            return Result.success(res.body()!!.result)
        }
        return Result.failure(IllegalArgumentException(res.message()))
    }

    override suspend fun getEventDetailData(eventIdx: Int): Result<ResponseEventDetailData.ResponseEventDetailResult> {
        val res = service.getEventDetailData(eventIdx)
        if(res.isSuccessful) {
            return Result.success(res.body()!!.result)
        }
        return Result.failure(IllegalArgumentException(res.message()))
    }
}