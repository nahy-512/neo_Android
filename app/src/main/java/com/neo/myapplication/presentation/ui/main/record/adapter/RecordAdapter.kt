package com.neo.myapplication.presentation.ui.main.record.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.databinding.ItemFgRecordRvRecordsBinding

class RecordAdapter(private val onClick : (Int) -> Unit) : RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {
    // TODO: 데이터 목록 넣기
    inner class RecordViewHolder(private val binding: ItemFgRecordRvRecordsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener { onClick.invoke(0) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        return RecordViewHolder(ItemFgRecordRvRecordsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 10 // TODO: 임의로 10

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind()
    }
}