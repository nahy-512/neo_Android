package com.neo.myapplication.presentation.ui.recorddetail.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.databinding.ItemRecordDetailCommentLeftBinding
import com.neo.myapplication.databinding.ItemRecordDetailCommentRightBinding

class RecordDetailCommentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class RecordDetailCommentLeftViewHolder(private val binding : ItemRecordDetailCommentLeftBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

    inner class RecordDetailCommentRightViewHolder(private val binding : ItemRecordDetailCommentRightBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            0 -> RecordDetailCommentLeftViewHolder(ItemRecordDetailCommentLeftBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
            else -> RecordDetailCommentRightViewHolder(ItemRecordDetailCommentRightBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int = 10 // TODO: 임시로 5개로 설정

    override fun getItemViewType(position: Int): Int {
        return position % 2 // TODO: 홀/짝 구분하기 위함
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is RecordDetailCommentRightViewHolder -> {
                holder.bind()
            }
            is RecordDetailCommentLeftViewHolder -> {
                holder.bind()
            }
        }
    }
}