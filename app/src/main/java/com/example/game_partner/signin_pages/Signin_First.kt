package com.example.game_partner.signin_pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.game_partner.R
import kotlinx.android.synthetic.main.signin_first.*

class Signin_First : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_first)

        next1.setOnClickListener {
            val intent = Intent(this, Signin_Second::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_right_to_zero,R.anim.slide_zero_to_left)
        }
    }
}