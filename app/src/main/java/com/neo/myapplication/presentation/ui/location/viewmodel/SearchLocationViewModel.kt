package com.neo.myapplication.presentation.ui.location.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neo.myapplication.data.remote.response.ResponseLocationData
import com.neo.myapplication.domain.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchLocationViewModel @Inject constructor(private val repo : LocationRepository): ViewModel() {
    var userInputKeyword = MutableLiveData<String>().apply { value = "" }

    private val _locationList = MutableLiveData<MutableList<ResponseLocationData.LocationData>>()
    val locationList : LiveData<MutableList<ResponseLocationData.LocationData>> = _locationList

    fun onSearchClicked() {
        userInputKeyword.value?.let {
            viewModelScope.launch {
                repo.getLocationSearch(it)
                    .onSuccess { _locationList.value = it as MutableList }
            }
        }
    }
}