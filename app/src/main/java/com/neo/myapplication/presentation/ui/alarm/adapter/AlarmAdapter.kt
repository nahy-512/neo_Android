package com.neo.myapplication.presentation.ui.alarm.adapter

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ItemActAlarmRvAlarmsBinding
import com.neo.myapplication.presentation.ui.share.view.ShareActivity
import kotlin.reflect.KFunction1

class AlarmAdapter(private val onClick : (Int) -> Unit) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {
    private lateinit var context : Context

    inner class AlarmViewHolder(private val binding: ItemActAlarmRvAlarmsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener {
                binding.root.setOnClickListener { onClick.invoke(0) }
            }
            when(adapterPosition % 4) {
                0 -> binding.ivAlarmTool.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.main_yellow))
                1 -> binding.ivAlarmTool.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.main_green))
                2 -> binding.ivAlarmTool.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.main_red))
                3 -> binding.ivAlarmTool.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.main_blue))
            }

            when(adapterPosition) {
                0 -> binding.tvAlarm.text = "벌써 푸와 만난 지 180일이 지났어요!"
                1 -> binding.tvAlarm.text = "푸와 마지막으로 만난 게 2023.01.02 예요!\n우리 오랜만에 모일까요?"
                2 -> binding.tvAlarm.text = "혹시 나이아카와 만나기로 하지 않았나요?"
                3 -> binding.tvAlarm.text = "나이아카와 만난 지 365일이 지났어요!\n오늘 한 번 연락해볼까요?"
                4 -> binding.tvAlarm.text = "오늘은 헤이즐을 못 본 지 30일이 되는 날이에요"
                5 -> binding.tvAlarm.text = "밥 한 번 먹자! 그리운 헤이즐을 보러 갑시다"
                6 -> binding.tvAlarm.text = "혹시 나이아카와 만나기로 하지 않았나요?"
                7 -> binding.tvAlarm.text = "춘배가 울고 있어요 :("
                8 -> binding.tvAlarm.text = "시들시들한 춘배에게 관심을 주세요!\n500일째 못 만났어요"
                9 -> binding.tvAlarm.text = "오늘이 어떤 날인지 아세요?\n코코아를 본 지 100일이나 지났어요!"
                10 -> binding.tvAlarm.text = "코코아는 잘 지낼까요? 모일에서 봐요!"
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        context = parent.context
        return AlarmViewHolder(ItemActAlarmRvAlarmsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 11

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind()
    }
}