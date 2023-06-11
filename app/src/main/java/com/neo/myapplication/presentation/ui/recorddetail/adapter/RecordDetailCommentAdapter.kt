package com.neo.myapplication.presentation.ui.recorddetail.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.R
import com.neo.myapplication.data.remote.response.ResponseReviewListData
import com.neo.myapplication.databinding.ItemRecordDetailCommentLeftBinding
import com.neo.myapplication.databinding.ItemRecordDetailCommentRightBinding

class RecordDetailCommentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context : Context
    var reviewList = mutableListOf<ResponseReviewListData.ResponseReviewListResult>()
    inner class RecordDetailCommentLeftViewHolder(private val binding : ItemRecordDetailCommentLeftBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ResponseReviewListData.ResponseReviewListResult) {
            binding.reviewData = item
            when(adapterPosition % 4) {
                0 -> binding.itemFgRecordDetailCommentLeftLayoutNickname.setCardBackgroundColor(ColorStateList.valueOf(context.resources.getColor(R.color.main_blue, null)))
                else -> binding.itemFgRecordDetailCommentLeftLayoutNickname.setCardBackgroundColor(ColorStateList.valueOf(context.resources.getColor(R.color.main_yellow, null)))
            }
        }
    }

    inner class RecordDetailCommentRightViewHolder(private val binding : ItemRecordDetailCommentRightBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ResponseReviewListData.ResponseReviewListResult) {
            binding.reviewData = item
            when(adapterPosition % 4) {
                1 -> binding.itemFgRecordDetailCommentRightLayoutNickname.setCardBackgroundColor(ColorStateList.valueOf(context.resources.getColor(R.color.main_red, null)))
                else -> binding.itemFgRecordDetailCommentRightLayoutNickname.setCardBackgroundColor(ColorStateList.valueOf(context.resources.getColor(R.color.main_green, null)))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return when(viewType) {
            0 -> RecordDetailCommentLeftViewHolder(ItemRecordDetailCommentLeftBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
            else -> RecordDetailCommentRightViewHolder(ItemRecordDetailCommentRightBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int = reviewList.size

    override fun getItemViewType(position: Int): Int {
        return position % 2 // TODO: 홀/짝 구분하기 위함
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is RecordDetailCommentRightViewHolder -> {
                holder.bind(reviewList[position])
            }
            is RecordDetailCommentLeftViewHolder -> {
                holder.bind(reviewList[position])
            }
        }
    }
}