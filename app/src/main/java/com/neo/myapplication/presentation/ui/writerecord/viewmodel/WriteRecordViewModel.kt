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


    private val _imagePath = MutableLiveData<Any>()
    val imagePath : LiveData<Any> = _imagePath

    fun setImagePath(path : Any) {
        _imagePath.value = path
    }

    private fun setTargetDate() : List<String> {
        return SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(Date(System.currentTimeMillis())).split('.')
    }
}