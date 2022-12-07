package com.example.baedal_baedal

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ChattingActivity : AppCompatActivity() {
    var PREFS_KEY = "prefs"
    var nickName_KEY = "nickName"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatting)

        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        var nickName = sharedPreferences.getString(nickName_KEY, null)!!
        val chatView = findViewById<ListView>(R.id.chatListView)
        val sendBtn = findViewById<Button>(R.id.chattingBtn)
        val editText = findViewById<EditText>(R.id.chattingEdit)

        val chatList = arrayListOf<ListViewModel2>()
        chatList.add(ListViewModel2("seokjin", "Hello"))


        val chatAdapter = ChattingAdapter(this, chatList)
        chatView.adapter = chatAdapter
        sendBtn.setOnClickListener {
            Toast.makeText(this, "${editText.text}", Toast.LENGTH_SHORT).show()
        }
    }
}