package com.example.islami.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.islami.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({startHomeActivity(); },2000)
    }

    private fun startHomeActivity() {
        val intent=Intent(this@SplashActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
