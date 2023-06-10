package com.neo.myapplication.presentation.ui.recorddetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neo.myapplication.data.remote.response.ResponseEventDetailData
import com.neo.myapplication.domain.repository.EventRepository
import com.neo.myapplication.domain.repository.ExamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordDetailViewModel @Inject constructor(private val eventRepository: EventRepository): ViewModel() {

    private val _eventDetail = MutableLiveData<ResponseEventDetailData.ResponseEventDetailResult>()
    val eventDetail : LiveData<ResponseEventDetailData.ResponseEventDetailResult> = _eventDetail

    fun getEventDetail(eventIdx : Int) {
        viewModelScope.launch {
            eventRepository.getEventDetailData(eventIdx)
                .onSuccess { Log.d("----", "getEventDetail: $it") }
        }
    }


}