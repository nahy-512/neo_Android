package com.neo.myapplication.presentation.ui.main.friends.view

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
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
    private val nicknameList : ArrayList<String> = arrayListOf(
        "첼라", "나이아카", "주씨", "춘배", "코코아", "푸", "다니엘", "헤이즐", "에릭", "아크"
    )


    private val friendAdapter by lazy {
        FriendAdapter(::onFriendClicked, nicknameList)
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

        // itemClick
        friendAdapter.setMyItemClickListener(object : FriendAdapter.MyItemClickListener {
            override fun onItemClick(nickname: String, plant: Int) {
                val intent = Intent(activity, FriendsDetailActivity::class.java)

                // 데이터 넣기
                intent.apply {
                    this.putExtra("nickname", nickname)
                    this.putExtra("image", plant)
                }
                // 화면 이동
                startActivity(intent, Bundle())
            }
        })
    }

    private fun onFriendClicked(positionIdx : Int) {
        //startActivity(Intent(requireActivity(), FriendsDetailActivity::class.java))
    }
}