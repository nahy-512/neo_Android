package com.neo.myapplication.presentation.ui.writerecord.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityWriteRecordBinding
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
    }


}