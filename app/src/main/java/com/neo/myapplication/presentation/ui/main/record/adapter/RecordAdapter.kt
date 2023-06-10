package com.neo.myapplication.presentation.ui.main.record.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.data.remote.response.ResponseEventListData
import com.neo.myapplication.databinding.ItemFgRecordRvRecordsBinding

class RecordAdapter(private val onClick : (Int) -> Unit) : RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {
    var recordList = mutableListOf<ResponseEventListData.ResponseEventListResult>()
    // TODO: 데이터 목록 넣기
    inner class RecordViewHolder(private val binding: ItemFgRecordRvRecordsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ResponseEventListData.ResponseEventListResult) {
            binding.data = item
            binding.root.setOnClickListener { onClick.invoke(0) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        return RecordViewHolder(ItemFgRecordRvRecordsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = recordList.size

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(recordList[position])
    }
}