package com.neo.myapplication.presentation.ui.writerecord.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neo.myapplication.R
import com.neo.myapplication.data.remote.response.ResponseLocationData
import com.neo.myapplication.databinding.ActivityWriteRecordBinding
import com.neo.myapplication.presentation.ui.location.view.SearchLocationActivity
import com.neo.myapplication.presentation.ui.writerecord.viewmodel.WriteRecordViewModel

class WriteRecordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWriteRecordBinding
    private val viewModel : WriteRecordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_record)

        initBinding()
    }

    private fun initBinding() {
        // TODO: 바인딩 추후 초기화
        binding.lifecycleOwner = this
        binding.activity = this
        binding.viewModel = viewModel
    }

    fun onOpenGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_PICK
        this.requestGalleryActivity.launch(intent)
    }

    private val requestGalleryActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data?.data != null) { //갤러리 캡쳐 결과값
                val clipData = it?.data?.clipData
                if (clipData == null) {
                    it.data!!.data?.let { it1 -> viewModel.setImagePath(it1) }
                }
            }
        }

    fun openLocationActivity() {
        val intent = Intent(this, SearchLocationActivity::class.java)
        this.requestLocationActivity.launch(intent)
    }

    private val requestLocationActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                it.data?.extras?.getString("LocationName")?.let { it1 -> viewModel.setUserSelectedLocation(it1) }
            }
        }
}