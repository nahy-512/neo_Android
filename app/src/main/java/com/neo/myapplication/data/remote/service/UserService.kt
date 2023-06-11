package com.neo.myapplication.data.remote.service

import com.neo.myapplication.data.remote.response.ResponseHomeListData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/users/{userIdx}")
    suspend fun getUserList(
        @Path("userIdx") userIdx : Int
    ) : Response<ResponseHomeListData.ResponseHomeListResult>
}