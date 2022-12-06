package com.example.baedal_baedal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val homeBtn = findViewById<Button>(R.id.homeBtn)
        val chatBtn = findViewById<Button>(R.id.chatBtn)
        val myPageBtn = findViewById<Button>(R.id.myPageBtn)

        val homeIntent = Intent(this, MainInterfaceActivity::class.java)
        val chatIntent = Intent(this, ChatActivity::class.java)
        val myPageIntent = Intent(this, MyPageActivity::class.java)

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