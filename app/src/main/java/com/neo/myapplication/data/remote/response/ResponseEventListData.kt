package com.neo.myapplication.data.remote.response

import com.neo.myapplication.presentation.util.BaseResponse

data class ResponseEventListData (
    val result : List<ResponseEventListResult>
) : BaseResponse() {
    data class ResponseEventListResult(
        val event_idx : Int,
        val host_idx : Int,
        val event_date_year : Int,
        val event_date_month : String,
        val event_date_day : Int,
        val location : String,
        val event_img : String?
    )
}