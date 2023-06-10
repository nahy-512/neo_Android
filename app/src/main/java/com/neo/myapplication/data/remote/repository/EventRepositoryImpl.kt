package com.neo.myapplication.data.remote.repository

import com.neo.myapplication.data.remote.response.ResponseEventListData
import com.neo.myapplication.domain.repository.EventRepository
import com.neo.myapplication.domain.source.EventSource
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(private val source : EventSource): EventRepository{
    override suspend fun getEventListData(userIdx: Int): Result<List<ResponseEventListData.ResponseEventListResult>> {
        return source.getEventListData(userIdx)
    }
}