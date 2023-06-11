package com.neo.myapplication.data.remote.response

import com.neo.myapplication.presentation.util.BaseResponse

data class ResponseReviewListData (
    val result : List<ResponseReviewListResult>
) : BaseResponse() {
    data class ResponseReviewListResult(
        val reviewIdx : Int,
        val nickname : String,
        val review : String
    )
}