package com.neo.myapplication.data.remote.source

import android.util.Log
import com.neo.myapplication.data.remote.response.ResponseHomeListData
import com.neo.myapplication.data.remote.service.UserService
import com.neo.myapplication.domain.source.UserSource
import retrofit2.Response
import javax.inject.Inject

class UserRemoteSource @Inject constructor(private val service : UserService): UserSource {
    override suspend fun getUserListData(userIdx: Int): Result<ResponseHomeListData.ResponseHomeListResult> {
        val res = service.getUserList(userIdx)
        if(res.isSuccessful) {
            Log.d("API성공", res.body()!!.myStatus)
            return Result.success(res.body()!!)
        }
        return Result.failure(IllegalArgumentException(res.message()))
    }

}