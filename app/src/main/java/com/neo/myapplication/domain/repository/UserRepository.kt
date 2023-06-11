package com.neo.myapplication.domain.repository

import com.neo.myapplication.data.remote.response.ResponseHomeListData

interface UserRepository {
    suspend fun getUserListData(userIdx : Int) : Result<ResponseHomeListData.ResponseHomeListResult>
}