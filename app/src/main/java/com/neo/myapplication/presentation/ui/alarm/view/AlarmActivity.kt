package com.neo.myapplication.presentation.ui.alarm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neo.myapplication.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}