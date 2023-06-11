package com.neo.myapplication.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.provider.LiveFolders.INTENT
import androidx.appcompat.app.AppCompatActivity
import com.neo.myapplication.presentation.ui.login.LoginActivity

class SpalshActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(700)

        startActivity(Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        finish()
    }
}