package com.neo.myapplication.presentation.ui.recorddetail.viewmodel

import android.icu.text.AlphabeticIndex.Record
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neo.myapplication.data.data.RecordData
import com.neo.myapplication.data.remote.response.ResponseEventDetailData
import com.neo.myapplication.data.remote.response.ResponseReviewListData
import com.neo.myapplication.domain.repository.EventRepository
import com.neo.myapplication.domain.repository.ExamRepository
import com.neo.myapplication.domain.repository.ReviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordDetailViewModel @Inject constructor(private val eventRepository: EventRepository, private val reviewRepository: ReviewRepository): ViewModel() {

    private val _eventDetail = MutableLiveData<ResponseEventDetailData.ResponseEventDetailResult>()
    val eventDetail : LiveData<ResponseEventDetailData.ResponseEventDetailResult> = _eventDetail

    private val _recordList = MutableLiveData<RecordData>()
    val recordList : LiveData<RecordData> = _recordList

    fun getEventDetail(eventIdx : Int) {
        viewModelScope.launch {
            eventRepository.getEventDetailData(eventIdx)
                .onSuccess {
                    _eventDetail.value = it
                    reviewRepository.getReviewListData(it.eventIdx)
                    .onSuccess {
                        MappingRecordData(it)
                    }}
        }
    }

    private fun MappingRecordData(recordList : List<ResponseReviewListData.ResponseReviewListResult>) {
        Log.d("----", "MappingRecordData: ${eventDetail.value}")
        _recordList.value = RecordData(eventDetail.value!!.eventIdx, eventDetail.value!!.eventDate.substring(2, 10).replace("-", "."), eventDetail.value!!.result, eventDetail.value!!.eventImg, eventDetail.value!!.reviewed, recordList)
    }






}