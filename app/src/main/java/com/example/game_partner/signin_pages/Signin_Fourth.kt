package com.example.game_partner.signin_pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.view.get
import com.example.game_partner.R
import com.example.game_partner.SharedPreferences.MyApplication.Companion.prefs
import kotlinx.android.synthetic.main.signin_fourth.*
import java.util.*

class Signin_Fourth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_fourth)

        val year = prefs.getLong("year",0).toInt()
        val month = prefs.getLong("month",0).toInt()
        val day = prefs.getLong("day",0).toInt()

        datePicker.updateDate(year, month, day)

        datePicker.maxDate = System.currentTimeMillis()



        next4.setOnClickListener {
            val intent = Intent(this, Signin_Fifth::class.java)
            startActivity(intent)
            datePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            }
            saveData()
            overridePendingTransition(R.anim.slide_right_to_zero,R.anim.slide_zero_to_left)
        }


        back3.setOnClickListener {
            val intent = Intent(this, Signin_Third::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_left_to_zero, R.anim.slide_zero_to_right)
        }
    }

    fun saveData() {
        prefs.setLong("year", datePicker.year.toLong())
        prefs.setLong("month", datePicker.month.toLong())
        prefs.setLong("day", datePicker.dayOfMonth.toLong())
    }
}