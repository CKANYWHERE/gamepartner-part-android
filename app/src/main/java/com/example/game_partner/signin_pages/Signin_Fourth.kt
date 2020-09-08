package com.example.game_partner.signin_pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.game_partner.R
import com.example.game_partner.SharedPreferences.MyApplication.Companion.prefs
import kotlinx.android.synthetic.main.signin_fourth.*
import kotlinx.android.synthetic.main.signin_third.*

class Signin_Fourth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_fourth)

        datePicker.maxDate = System.currentTimeMillis()

        next4.setOnClickListener {
            val intent = Intent(this, Signin_Fifth::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_to_zero,R.anim.slide_zero_to_left)
        }

        back3.setOnClickListener {
            val intent = Intent(this, Signin_Third::class.java)
            startActivity(intent)
            prefs.getBoolean("man", man.isChecked)
            prefs.getBoolean("woman", false)
            overridePendingTransition(R.anim.slide_left_to_zero, R.anim.slide_zero_to_right)
        }
    }
}