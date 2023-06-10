package com.neo.myapplication.presentation.ui.alarm.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.databinding.ItemActAlarmRvAlarmsBinding
import com.neo.myapplication.presentation.ui.share.view.ShareActivity
import kotlin.reflect.KFunction1

class AlarmAdapter(private val onClick : (Int) -> Unit) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {
    inner class AlarmViewHolder(private val binding: ItemActAlarmRvAlarmsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener {
                binding.root.setOnClickListener { onClick.invoke(0) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        return AlarmViewHolder(ItemActAlarmRvAlarmsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind()
    }
}