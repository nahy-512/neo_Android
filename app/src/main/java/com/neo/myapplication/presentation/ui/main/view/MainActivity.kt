package com.neo.myapplication.presentation.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityMainBinding
import com.neo.myapplication.presentation.ui.main.friends.view.FriendsFragment
import com.neo.myapplication.presentation.ui.main.record.view.RecordFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNav()
    }

    private fun initBottomNav() {
        binding.mainLayoutBottomNavigation.itemIconTintList = null

        binding.mainLayoutBottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.main_bottom_nav_home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }// TODO: HomeFragment 이동

                R.id.main_bottom_nav_friends -> {
                    FriendsFragment().changeFragment()
                }// TODO: FriendsFragment 이동

                R.id.main_bottom_nav_record -> {
                    RecordFragment().changeFragment()
                }// TODO: RecordFragment 이동
            }
            return@setOnItemSelectedListener true
        }

        binding.mainLayoutBottomNavigation.setOnItemReselectedListener {  } // 바텀네비 재클릭시 화면 재생성 방지
    }

    private fun Fragment.changeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.main_layout_container, this).commit()
    }
}