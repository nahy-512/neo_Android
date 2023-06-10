package com.neo.myapplication.presentation.ui.main.friends.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.neo.myapplication.R
import com.neo.myapplication.databinding.FragmentFriendsBinding
import com.neo.myapplication.presentation.ui.main.friends.adapter.FriendAdapter
import java.util.ArrayList
import java.util.Arrays

class FriendsFragment : Fragment() {
    private lateinit var binding: FragmentFriendsBinding

    // adding values to arrayList
    private val imageList : ArrayList<Int> = arrayListOf(
        R.drawable.test_plant2, R.drawable.ic_check, R.drawable.test_plant2, R.drawable.test_plant2, R.drawable.test_plant2,
        R.drawable.test_plant2, R.drawable.test_plant2, R.drawable.test_plant2)

    private val friendAdapter by lazy {
        FriendAdapter(::onFriendClicked, imageList)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friends, container, false)

        initBinding()
        initFriend()

        return binding.root
    }

    private fun initBinding() {
        //TODO: API 연결시 Binding 연결하기
    }

    private fun initFriend() {
        val rv = binding.fgFriendsRvContent
        rv.adapter = friendAdapter
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun onFriendClicked(positionIdx : Int) {
        startActivity(Intent(requireActivity(), FriendsDetailActivity::class.java))
    }
}