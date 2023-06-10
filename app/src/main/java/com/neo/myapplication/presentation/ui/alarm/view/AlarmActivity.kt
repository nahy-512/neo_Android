package com.neo.myapplication.presentation.ui.alarm.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neo.myapplication.databinding.ActivityAlarmBinding
import com.neo.myapplication.presentation.ui.alarm.adapter.AlarmAdapter
import com.neo.myapplication.presentation.ui.main.view.MainActivity

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlarmBinding
    private val alarmAdapter by lazy {
        AlarmAdapter(::onAlarmClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAlarm()


    }

    private fun initAlarm() {
        binding.actAlarmRvContent.adapter = alarmAdapter
    }

    private fun onAlarmClicked(positionIdx : Int) {
        startActivity(Intent(this, MainActivity::class.java))
    }


}