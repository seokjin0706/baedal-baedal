package com.example.baedal_baedal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        var chatList = arrayListOf<ChatListModel>()
        val listview = findViewById<ListView>(R.id.chatListView)

        val chatAdapter = ChatListViewAdapter(this, chatList)
        listview.adapter = chatAdapter
    }
}