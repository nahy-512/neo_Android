package com.neo.myapplication.presentation.ui.main.home.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.neo.myapplication.R
import com.neo.myapplication.databinding.FragmentHomeBinding
import com.neo.myapplication.presentation.ui.alarm.view.AlarmActivity
import com.neo.myapplication.presentation.ui.main.viewmodel.MainViewModel

class HomeFragment: Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel : MainViewModel by activityViewModels()
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

        binding.ivMainHomeAlarm.setOnClickListener {
            activity?.let {
                val intent = Intent(it, AlarmActivity::class.java)
                it.startActivity(intent)
            }
        }

        return binding.root
    }

    /*
    private fun initBinding() {
        binding.viewModel = viewModel
    }

    private fun initHomeData() {
        viewModel.getUserData()
    } */
}