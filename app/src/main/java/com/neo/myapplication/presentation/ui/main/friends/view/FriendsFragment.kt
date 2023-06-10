package com.neo.myapplication.presentation.ui.main.friends.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.neo.myapplication.R
import com.neo.myapplication.databinding.FragmentFriendsBinding
import com.neo.myapplication.presentation.ui.main.friends.adapter.FriendAdapter

class FriendsFragment : Fragment() {
    private lateinit var binding: FragmentFriendsBinding
    private val friendAdapter by lazy {
        FriendAdapter(::onFriendClicked)
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
        // TODO: API 연결시 Binding 연결하기
    }

    private fun initFriend() {
        binding.fgFriendsRvContent.adapter = friendAdapter
    }

    private fun onFriendClicked(positionIdx : Int) {
        Toast.makeText(requireContext(), positionIdx.toString(), Toast.LENGTH_SHORT).show()
    }
}