package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MyPageActivity : AppCompatActivity() {
    var PREFS_KEY = "prefs"
    var adress_KEY = "adress"
    var nickName_KEY = "nickName"

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
        val homeBtn = findViewById<Button>(R.id.homeBtn)
        val chatBtn = findViewById<Button>(R.id.chatBtn)
        val myPageBtn = findViewById<Button>(R.id.myPageBtn)
        var nickTxt = findViewById<TextView>(R.id.nicknameTxt)
        var addressTxt = findViewById<TextView>(R.id.addressTxt)

        val loginIntent = Intent(this, MainActivity::class.java)
        val homeIntent = Intent(this, MainInterfaceActivity::class.java)
        val chatIntent = Intent(this, ChatActivity::class.java)
        val myPageIntent = Intent(this, MyPageActivity::class.java)

        // nicknameTxt, addressTxt
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        var nickName = sharedPreferences.getString(nickName_KEY, null)!!
        var adress = sharedPreferences.getString(adress_KEY, null)!!

        nickTxt.setText(nickName)
        addressTxt.setText(adress)

        logoutBtn.setOnClickListener {
            Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(loginIntent)
        }
        homeBtn.setOnClickListener {
            startActivity(homeIntent)
        }

        chatBtn.setOnClickListener {
            startActivity(chatIntent)
        }

        myPageBtn.setOnClickListener {
            startActivity(myPageIntent)
        }
    }
}