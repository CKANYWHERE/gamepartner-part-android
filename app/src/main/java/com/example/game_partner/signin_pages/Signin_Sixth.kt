package com.example.game_partner.signin_pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.game_partner.R
import kotlinx.android.synthetic.main.signin_second.*
import kotlinx.android.synthetic.main.signin_sixth.*

class Signin_Sixth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_sixth)

        next6.setOnClickListener {
            val intent = Intent(this, Signin_Seventh::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_to_zero,R.anim.slide_zero_to_left)
        }

        back5.setOnClickListener {
            val intent = Intent(this, Signin_Fifth::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_left_to_zero, R.anim.slide_zero_to_right)
        }
    }
}