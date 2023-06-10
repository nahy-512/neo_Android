package com.neo.myapplication.presentation.ui.recorddetail.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityRecordDetailBinding
import com.neo.myapplication.presentation.ui.recorddetail.adapter.RecordDetailCommentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecordDetailBinding
    private val recordDetailCommentAdapter by lazy {
        RecordDetailCommentAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_record_detail)

        initBinding()
        initComments()
    }


    private fun initBinding() {
        // TODO: 추후 바인딩 init
    }

    private fun initComments() {
        binding.fgRecordDetailRvComments.adapter = recordDetailCommentAdapter
    }


}