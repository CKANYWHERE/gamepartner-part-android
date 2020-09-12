package com.example.game_partner.signin_pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.game_partner.R
import com.example.game_partner.SharedPreferences.MyApplication.Companion.prefs
import kotlinx.android.synthetic.main.signin_third.*

class Signin_Third : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_third)


        radioGroup.check(prefs.getInt("radioGroup", 0))

        val toast = Toast.makeText(this, "성별을 체크해주세요", Toast.LENGTH_SHORT)
        val timer = object: CountDownTimer(800, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                toast.show()
            }

            override fun onFinish() {
                toast.cancel()
            }
        }



        next3.setOnClickListener {
            if(man.isChecked || woman.isChecked) {
                val intent = Intent(this, Signin_Fourth::class.java)
                startActivity(intent)

                prefs.setInt("radioGroup", radioGroup.checkedRadioButtonId)
                overridePendingTransition(R.anim.slide_right_to_zero, R.anim.slide_zero_to_left)
            } else {
                toast.show()
                timer.start()
            }
        }

        back2.setOnClickListener {
            val intent = Intent(this, Signin_Second::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_left_to_zero, R.anim.slide_zero_to_right)
        }
    }
}