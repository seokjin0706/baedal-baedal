package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView



class MainInterfaceActivity : AppCompatActivity() {

    var PREFS_KEY = "prefs"
    var userID_KEY = "userID"
    var passWord_KEY = "passWord"
    var userName_KEY = "userName"
    var phoneNumber_KEY = "phoneNumber"
    var adress_KEY = "adress"
    var nickName_KEY = "nickName"

    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_interface)

        // 세션
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        var userID = sharedPreferences.getString(userID_KEY, null)!!
        var passWord = sharedPreferences.getString(passWord_KEY, null)!!
        var userName = sharedPreferences.getString(userName_KEY, null)!!
        var phoneNumber = sharedPreferences.getString(phoneNumber_KEY, null)!!
        var adress = sharedPreferences.getString(adress_KEY, null)!!
        var nickName = sharedPreferences.getString(nickName_KEY, null)!!
        Log.d("MMMM", "MainInterface - $userID  $passWord  $userName  $phoneNumber  $adress  $nickName")

        val writeBtn = findViewById<Button>(R.id.writeBtn)
        val chatBtn = findViewById<Button>(R.id.chatBtn)
        val myPageBtn = findViewById<Button>(R.id.myPageBtn)

        val writeIntent = Intent(this, WriteActivity::class.java)
        val chatIntent = Intent(this, ChatActivity::class.java)
        val myPageIntent = Intent(this, MyPageActivity::class.java)

        val sentenceList = arrayListOf<ListViewModel>(
            ListViewModel("ic_launcher_background", "박", "정왕1", "제목1", "내용1"),
            ListViewModel("ic_launcher_background", "박2", "정왕2", "제목2", "내용2"),
            ListViewModel("ic_launcher_background", "박", "정왕1", "제목1", "내용1"),
            ListViewModel("ic_launcher_background", "박2", "정왕2", "제목2", "내용2"),
            ListViewModel("ic_launcher_background", "박", "정왕1", "제목1", "내용1"),
            ListViewModel("ic_launcher_background", "박2", "정왕2", "제목2", "내용2"),
            ListViewModel("ic_launcher_background", "박", "정왕1", "제목1", "내용1"),
            ListViewModel("ic_launcher_background", "박2", "정왕2", "제목2", "내용2"),
            ListViewModel("ic_launcher_background", "박", "정왕1", "제목1", "내용1"),
            ListViewModel("ic_launcher_background", "박2", "정왕2", "제목2", "내용2"),
        )


        val sentenceAdapter = ListViewAdapter(this, sentenceList)
        val listview = findViewById<ListView>(R.id.sentenceListView)

        listview.adapter = sentenceAdapter

        writeBtn.setOnClickListener {
            startActivity(writeIntent)
        }

        chatBtn.setOnClickListener {
            startActivity(chatIntent)
        }

        myPageBtn.setOnClickListener {
            startActivity(myPageIntent)
        }
    }


}