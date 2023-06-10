package com.neo.myapplication.presentation.ui.location.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neo.myapplication.R
import com.neo.myapplication.data.remote.response.ResponseLocationData
import com.neo.myapplication.databinding.ActivitySearchLocationBinding
import com.neo.myapplication.presentation.ui.location.adapter.SearchLocationAdapter
import com.neo.myapplication.presentation.ui.location.viewmodel.SearchLocationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchLocationActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchLocationBinding
    private val viewModel : SearchLocationViewModel by viewModels()
    private val adapter by lazy {
        SearchLocationAdapter(::onLocationSelected)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_location)

        initBinding()
        initResultRV()
        observeLocationResult()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
        binding.activity = this
        binding.viewModel = viewModel
    }

    private fun initResultRV() {
        binding.searchLocationRvLocations.adapter = adapter
    }

    private fun observeLocationResult() {
        viewModel.locationList.observe(this) {
            adapter.locationList = it
            adapter.notifyDataSetChanged()
        }
    }

    private fun onLocationSelected(locationName : String) {
        setResult(Activity.RESULT_OK, Intent().putExtra("LocationName", locationName))
        finish()
    }

}