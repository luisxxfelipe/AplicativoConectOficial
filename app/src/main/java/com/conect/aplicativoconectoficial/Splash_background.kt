package com.conect.aplicativoconectoficial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash_background : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_background)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, tela_bem_vindo::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}