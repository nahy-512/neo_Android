package com.neo.myapplication.presentation.ui.writerecord.viewmodel

import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.Locale

class WriteRecordViewModel : ViewModel() {

    private val _targetDate = MutableLiveData<MutableList<String>?>().apply { value = setTargetDate() as MutableList }
    val targetDate : LiveData<MutableList<String>?> = _targetDate

    private val _location = MutableLiveData<String>().apply { value = "장소를 입력해주세요." }
    val location : LiveData<String> = _location


    private val _imagePath = MutableLiveData<Any>()
    val imagePath : LiveData<Any> = _imagePath

    fun setImagePath(path : Any) {
        _imagePath.value = path
    }

    private fun setTargetDate() : List<String> {
        return SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(Date(System.currentTimeMillis())).split('.')
    }

    fun setUserSelectedLocation(location : String) {
        _location.value = location
    }
}