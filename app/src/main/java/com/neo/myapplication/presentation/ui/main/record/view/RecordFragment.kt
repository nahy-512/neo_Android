package com.neo.myapplication.presentation.ui.main.record.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.neo.myapplication.R
import com.neo.myapplication.databinding.FragmentRecordBinding
import com.neo.myapplication.presentation.ui.main.record.adapter.RecordAdapter
import com.neo.myapplication.presentation.ui.recorddetail.view.RecordDetailActivity
import com.neo.myapplication.presentation.ui.writerecord.view.WriteRecordActivity

class RecordFragment : Fragment() {
    private lateinit var binding : FragmentRecordBinding
    private val recordAdapter by lazy {
        RecordAdapter(::onRecordClicked)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_record, container, false)

        initBinding()
        initRecord()

        return binding.root
    }

    private fun initBinding() {
        binding.fragment = this
        // TODO: API 연결시 Binding 연결하기
    }

    private fun initRecord() {
        binding.fgRecordRvContent.adapter = recordAdapter
    }

    private fun onRecordClicked(positionIdx : Int) {
        // TODO: 추후 기록 인덱스 보내기
        startActivity(Intent(requireActivity(), RecordDetailActivity::class.java))
    }

    fun onPressFab() {
        startActivity(Intent(requireActivity(), WriteRecordActivity::class.java))
    }

}