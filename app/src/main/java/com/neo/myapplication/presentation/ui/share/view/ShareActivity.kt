package com.neo.myapplication.presentation.ui.share.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neo.myapplication.databinding.ActivityShareBinding

class ShareActivity : AppCompatActivity() {
    private lateinit var binding : ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}