package com.example.game_partner.signin_pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.game_partner.R
import kotlinx.android.synthetic.main.signin_fifth.*
import kotlinx.android.synthetic.main.signin_second.*

class Signin_Fifth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_fifth)
        val numberPickerArray = resources.getStringArray(R.array.My_array)

        // Set the number picker minimum and maximum values
        number_picker.minValue = 0
        number_picker.maxValue = numberPickerArray.size - 1

        // Set the valued to be displayed in number picker
        number_picker.displayedValues = numberPickerArray

        // Initializing an ArrayAdapter

        next5.setOnClickListener {
            val intent = Intent(this, Signin_Sixth::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_right_to_zero,R.anim.slide_zero_to_left)
        }

        back4.setOnClickListener {
            val intent = Intent(this, Signin_Fourth::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_left_to_zero, R.anim.slide_zero_to_right)
        }
    }
}
