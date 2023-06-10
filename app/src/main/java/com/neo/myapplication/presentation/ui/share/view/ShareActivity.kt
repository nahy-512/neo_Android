package com.neo.myapplication.presentation.ui.share.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neo.myapplication.databinding.ActivityShareBinding
import com.neo.myapplication.presentation.ui.alarm.view.AlarmActivity

class ShareActivity : AppCompatActivity() {
    private lateinit var binding : ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackButton()

    }

    private fun onBackButton() {
        binding.actShareIvBack.setOnClickListener {
            startActivity(Intent(this, AlarmActivity::class.java))
        }
    }
}