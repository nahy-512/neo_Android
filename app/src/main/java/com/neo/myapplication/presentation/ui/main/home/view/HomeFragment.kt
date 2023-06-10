package com.neo.myapplication.presentation.ui.main.home.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neo.myapplication.R
import com.neo.myapplication.databinding.FragmentHomeBinding
import com.neo.myapplication.presentation.ui.alarm.view.AlarmActivity

class HomeFragment: Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnAlarm.setOnClickListener {
            activity?.let {
                val intent = Intent(it, AlarmActivity::class.java)
                it.startActivity(intent)
            }
        }

        return binding.root
    }

}