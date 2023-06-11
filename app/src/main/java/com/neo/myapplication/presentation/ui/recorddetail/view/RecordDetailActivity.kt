package com.neo.myapplication.presentation.ui.recorddetail.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityRecordDetailBinding
import com.neo.myapplication.presentation.ui.recorddetail.adapter.RecordDetailCommentAdapter
import com.neo.myapplication.presentation.ui.recorddetail.viewmodel.RecordDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify

@AndroidEntryPoint
class RecordDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecordDetailBinding
    private val viewModel : RecordDetailViewModel by viewModels()
    private val recordDetailCommentAdapter by lazy {
        RecordDetailCommentAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_record_detail)

        initBinding()
        initComments()
        observeRecord()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getEventDetail(intent.getIntExtra("eventIdx", 0))
    }


    private fun initBinding() {
        binding.activity = this
    }

    private fun initComments() {
        binding.fgRecordDetailRvComments.adapter = recordDetailCommentAdapter
    }

    private fun observeRecord() {
        viewModel.recordList.observe(this) {
            binding.recordData = it
            recordDetailCommentAdapter.reviewList = it.reviewList as MutableList
            recordDetailCommentAdapter.notifyDataSetChanged()
        }
    }

    fun onSaveClicked() {
        finish()
    }

}