package com.neo.myapplication.data.remote.response

import com.neo.myapplication.presentation.util.BaseResponse


data class ResponseHomeListData (
    val result : ResponseHomeListResult
) : BaseResponse() {
    data class ResponseHomeListResult(
        val myStatus: String
    )
}