package com.neo.myapplication.presentation.ui.main.friends.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityFriendDetailBinding

class FriendsDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFriendDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_friend_detail)


    }
}