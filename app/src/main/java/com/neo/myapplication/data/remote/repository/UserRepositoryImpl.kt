package com.neo.myapplication.data.remote.repository

import com.neo.myapplication.data.remote.response.ResponseHomeListData
import com.neo.myapplication.domain.repository.UserRepository
import com.neo.myapplication.domain.source.UserSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val source: UserSource): UserRepository {
    override suspend fun getUserListData(userIdx: Int): Result<ResponseHomeListData.ResponseHomeListResult> {
        return source.getUserListData(userIdx)
    }
}