package com.neo.myapplication.presentation.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityMainBinding
import com.neo.myapplication.presentation.ui.main.friends.view.FriendsFragment
import com.neo.myapplication.presentation.ui.main.home.view.HomeFragment
import com.neo.myapplication.presentation.ui.main.record.view.RecordFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showInit()
        initBottomNav()
    }

    private fun initBottomNav() {
        binding.mainLayoutBottomNavigation.itemIconTintList = null

        binding.mainLayoutBottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.main_bottom_nav_home -> {
                    HomeFragment().changeFragment()
                }

                R.id.main_bottom_nav_friends -> {
                    FriendsFragment().changeFragment()
                }

                R.id.main_bottom_nav_record -> {
                    RecordFragment().changeFragment()
                }
            }
            return@setOnItemSelectedListener true
        }

        binding.mainLayoutBottomNavigation.setOnItemReselectedListener {  } // 바텀네비 재클릭시 화면 재생성 방지
    }

    private fun Fragment.changeFragment() {
        manager.beginTransaction().replace(R.id.main_layout_container, this).commit()
    }

    fun showInit() {
        val transaction = manager.beginTransaction()
            .add(R.id.main_layout_container, HomeFragment())
        transaction.commit()
    }
}