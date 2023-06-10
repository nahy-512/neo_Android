package com.neo.myapplication.presentation.ui.alarm.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.databinding.ActivityAlarmBinding
import com.neo.myapplication.presentation.ui.alarm.adapter.AlarmAdapter
import com.neo.myapplication.presentation.ui.main.view.MainActivity
import com.neo.myapplication.presentation.ui.share.view.ShareActivity

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlarmBinding
    private val alarmAdapter by lazy {
        AlarmAdapter(::onAlarmClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.actAlarmRvContent
        val itemList: List<String> = getListData()

        recyclerView.adapter = alarmAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        initAlarm()


    }

    private fun initAlarm() {
        binding.actAlarmRvContent.adapter = alarmAdapter
    }

    private fun onAlarmClicked(position : Int) {
        startActivity(Intent(this, ShareActivity::class.java))
    }


    private fun getListData() : List<String> {
        return listOf()
    }


}