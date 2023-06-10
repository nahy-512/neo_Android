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
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        context = parent.context
        return AlarmViewHolder(ItemActAlarmRvAlarmsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind()
    }
}