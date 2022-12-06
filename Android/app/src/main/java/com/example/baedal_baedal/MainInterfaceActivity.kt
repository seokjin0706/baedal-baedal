package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainInterfaceActivity : AppCompatActivity() {

    /*private lateinit var binding: ActivityMainInterfaceBinding*/

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_interface)

        val writeBtn = findViewById<Button>(R.id.writeBtn)
        val chatBtn = findViewById<Button>(R.id.chatBtn)
        val myPageBtn = findViewById<Button>(R.id.myPageBtn)

        val writeIntent = Intent(this, WriteActivity::class.java)
        val chatIntent = Intent(this, ChatActivity::class.java)
        val myPageIntent = Intent(this, MyPageActivity::class.java)

        /*binding = ActivityMainInterfaceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)*/


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