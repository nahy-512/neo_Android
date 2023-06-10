package com.neo.myapplication.domain.repository

import com.neo.myapplication.data.remote.response.ResponseEventListData

interface EventRepository {

    suspend fun getEventListData(userIdx : Int) : Result<List<ResponseEventListData.ResponseEventListResult>>
}