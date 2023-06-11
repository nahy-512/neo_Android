package com.neo.myapplication.presentation.ui.main.friends.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityFriendDetailBinding

class FriendsDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFriendDetailBinding
    private var count: Int = 180 // 초기값

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_friend_detail)

        count = binding.fgFriendDetailTvCount.text.toString().toInt()

        onClickListeners()
        onClickControlBtn()
    }

    override fun onStart() {
        super.onStart()

        initText()
    }

    private fun onClickListeners() {
        binding.fgFriendDetailIvBack.setOnClickListener{
            finish()
        }
        binding.fgFriendDetailBtnSave.setOnClickListener{
            //TODO: 수정 API 호출
            Toast.makeText(this, "만남 주기가 수정되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun initText() {
        // FriendsFragment에서 넘어온 데이터
        val nickname = intent.getStringExtra("nickname")
        val image = intent.getIntExtra("image", 0)

        // 값 넣어주기
        with(binding) {
            fgFriendDetailTvFriendName.text = nickname
            fgFriendDetailIvPlant.setImageResource(image)
            // 내용
            fgFriendDetailTvContent.setText("${nickname}와 만난 지 365일이 지났어요!\n오늘 한 번 연락해볼까요?\n작년에 가디언즈 오브 갤럭시 2를 봤네요!\n이번에 개봉한 가디언즈 오브 갤럭시3을 보는 건 어떤가요?")
        }
    }

    private fun onClickControlBtn() {
        binding.fgFriendDetailIvMinus.setOnClickListener {
            if (count > 0) count--
            binding.fgFriendDetailTvCount.setText(count.toString())
        }
        binding.fgFriendDetailIvPlus.setOnClickListener {
            if (count < 365) count++
            binding.fgFriendDetailTvCount.setText(count.toString())
        }
    }
}