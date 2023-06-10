package com.neo.myapplication.presentation.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neo.myapplication.data.remote.response.ResponseEventListData
import com.neo.myapplication.domain.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val eventRepo : EventRepository): ViewModel() {

    private val _eventList = MutableLiveData<MutableList<ResponseEventListData.ResponseEventListResult>>()
    val eventList : LiveData<MutableList<ResponseEventListData.ResponseEventListResult>> = _eventList

    fun getEventList() {
        viewModelScope.launch {
            eventRepo.getEventListData(1)
                .onSuccess { _eventList.value = it as MutableList }
        }
    }
}