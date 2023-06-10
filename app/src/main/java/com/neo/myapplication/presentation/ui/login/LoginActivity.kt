package com.neo.myapplication.presentation.ui.login

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ActivityLoginBinding
import com.neo.myapplication.presentation.ui.main.view.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        // 해시 키
        val keyHash = Utility.getKeyHash(this)
        Log.d("keyHash", keyHash)

        kakaoLogin()
    }

    private fun kakaoLogin() {
        // 카카오계정 로그인 공통 callback 구성
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {  //토큰 에러
                Log.e(ContentValues.TAG, "카카오 계정으로 로그인 실패", error)

            } else if (token != null) {
                Log.i(ContentValues.TAG, "카카오 계정으로 로그인 성공 ${token.accessToken}")

                //토큰 저장
                val spf = getSharedPreferences("kakaoToken" , AppCompatActivity.MODE_PRIVATE)

                spf.edit().putString("access",token.accessToken).apply()
                val accessToken=spf.getString("access","")

                spf.edit().putString("refresh",token.refreshToken).apply()
                val refreshToken=spf.getString("refresh","")

                Log.d("kakao_access_token", "$accessToken")
                Log.d("kakao_refresh_token","$refreshToken")

                // 화면 이동
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        }
        // 카카오 로그인 버튼 클릭시 로그인
        binding.fgLoginBtnKakao.setOnClickListener {
            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }
}