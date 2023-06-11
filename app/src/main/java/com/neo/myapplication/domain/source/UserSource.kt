package com.neo.myapplication.domain.source

import com.neo.myapplication.data.remote.response.ResponseHomeListData

interface UserSource {
    suspend fun getUserListData(userIdx: Int) : Result<ResponseHomeListData.ResponseHomeListResult>
}