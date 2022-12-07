package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowWriteActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_write)
        

        val showWriteTitle = findViewById<TextView>(R.id.title_tv)
        val showWriteNickName = findViewById<TextView>(R.id.nickName_tv)
        val showWriteAddress = findViewById<TextView>(R.id.address_tv)
        val showWriteContent =  findViewById<TextView>(R.id.content_tv)
        val data = intent.getSerializableExtra("data") as ArrayList<HashMap<String, String>>
        val index = intent.getIntExtra("index", 0)

        showWriteTitle.text = data[index].getValue("title")
        showWriteNickName.text = data[index].getValue("nickName")
        showWriteAddress.text = data[index].getValue("address")
        showWriteContent.text = data[index].getValue("content")
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.chatBtn2).setOnClickListener {
            val chatIntent = Intent(this, ChatActivity::class.java)
            startActivity(chatIntent)
        }
    }

}