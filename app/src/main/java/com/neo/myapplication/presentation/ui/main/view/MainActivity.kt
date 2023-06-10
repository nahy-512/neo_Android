package com.neo.myapplication.presentation.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityMainBinding
import com.neo.myapplication.presentation.ui.main.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private var homeFragment = HomeFragment()

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 홈 Fragment 표시
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(R.id.main_layout_container, HomeFragment())
        fragmentTransaction.commit()

        initBottomNav()
    }

    private fun initBottomNav() {
        binding.mainLayoutBottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.main_bottom_nav_home -> {

                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }// TODO: HomeFragment 이동

                R.id.main_bottom_nav_friends -> {
                    Toast.makeText(this, "Friends", Toast.LENGTH_SHORT).show()
                }// TODO: FriendsFragment 이동

                R.id.main_bottom_nav_record -> {
                    Toast.makeText(this, "Record", Toast.LENGTH_SHORT).show()
                }// TODO: RecordFragment 이동
            }
            return@setOnItemSelectedListener true
        }

        binding.mainLayoutBottomNavigation.setOnItemReselectedListener {  } // 바텀네비 재클릭시 화면 재생성 방지
    }
}