package com.example.game_partner.signin_pages

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.game_partner.R
import com.example.game_partner.SharedPreferences.MyApplication
import com.example.game_partner.SharedPreferences.PreferenceUtil
import kotlinx.android.synthetic.main.signin_second.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class Signin_Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val idText = MyApplication.prefs.getString("Id", "")
        val pwText = MyApplication.prefs.getString("Pw", "")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_second)

        val inputId = findViewById<EditText>(R.id.ID)
        val inputPw = findViewById<EditText>(R.id.PW)

        ID.setText(idText)
        PW.setText(pwText)

        inputId.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               val id = s.toString()

                if(isValidID(inputId.text.toString())) {
                    if(id.length in 5..10)
                        inputId.setTextColor(Color.BLACK)
                    //inputPw.setBackgroundColor(Color.TRANSPARENT)

                } else {
                    inputId.setTextColor(Color.RED)
                    //inputPw.setBackgroundColor(Color.rgb(255, 135, 135))

                    inputId.setError("아이디 5~10글자")
                }
            }

        })

        inputPw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val id = s.toString()

                if(isValidPassword(inputPw.text.toString())) {
                    if(id.length in 8..15)
                    inputPw.setTextColor(Color.BLACK)

                    //inputPw.setBackgroundColor(Color.TRANSPARENT)
                    } else {
                    inputPw.setTextColor(Color.RED)
                    //inputPw.setBackgroundColor(Color.rgb(255, 135, 135))

                    inputPw.setError("숫자, 영어, 특수문자 포함 8~15글자")
                    }
                }
        })
        if (savedInstanceState != null) {
            val savedId = savedInstanceState.getString("IdStr")
            val savedPw = savedInstanceState.getString("PwStr")

            inputId.setText(savedId)
            inputPw.setText(savedPw)
        }

        val toast = Toast.makeText(this, "아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT)
        val timer = object: CountDownTimer(800, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                toast.show()
            }

            override fun onFinish() {
                toast.cancel()
            }
        }
        next2.setOnClickListener {
            if(isValidID(inputId.text.toString()) && isValidPassword(inputPw.text.toString())) {

                val intent = Intent(this, Signin_Third::class.java)

               // intent.putExtra("Id", inputId.text.toString())
               // intent.putExtra("Pw", inputPw.text.toString())

                startActivity(intent)

                MyApplication.prefs.setString("Id", inputId.text.toString())
                MyApplication.prefs.setString("Pw", inputPw.text.toString())

                overridePendingTransition(R.anim.slide_right_to_zero, R.anim.slide_zero_to_left)
            } else {toast.show()
                timer.start()
            }
        }

        back1.setOnClickListener {
            val intent = Intent(this, Signin_First::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_left_to_zero, R.anim.slide_zero_to_right)
        }
    }
    fun isValidID(text:String?):Boolean{
        val pattern = Pattern.compile("^(?=.*[A-za-z])(?=.*[A-za-z0-9]).{4,9}.\$")
        val matcher: Matcher = pattern.matcher(text)

        return matcher.matches()
    }

    fun isValidPassword(text: String?): Boolean {
        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&]).{7,14}.\$")
        val matcher: Matcher = pattern.matcher(text)

        return matcher.matches()
    }
}