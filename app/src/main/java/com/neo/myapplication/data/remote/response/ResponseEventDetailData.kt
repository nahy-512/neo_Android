package com.neo.myapplication.data.remote.response

import com.neo.myapplication.presentation.util.BaseResponse

data class ResponseEventDetailData(
    val result : ResponseEventDetailResult
) : BaseResponse() {
    data class ResponseEventDetailResult (
        val eventIdx : Int,
        val userIdx : Int,
        var eventDate : String,
        val result : String,
        val eventImg : String?,
        val reviewed : Boolean
            )
}
