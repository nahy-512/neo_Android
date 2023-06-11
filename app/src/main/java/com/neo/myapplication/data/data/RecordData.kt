package com.neo.myapplication.data.data

import com.neo.myapplication.data.remote.response.ResponseReviewListData

data class RecordData (
    val eventIdx : Int,
    val eventDate : String,
    val result : String,
    val eventImg : String?,
    val reviewed : Boolean,
    val reviewList : List<ResponseReviewListData.ResponseReviewListResult>
)