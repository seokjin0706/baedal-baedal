package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

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
        val chatIntent = Intent(this, ChattingActivity::class.java)
        val myPageIntent = Intent(this, MyPageActivity::class.java)

        // nicknameTxt, addressTxt
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        var nickName = sharedPreferences.getString(nickName_KEY, null)!!
        var adress = sharedPreferences.getString(adress_KEY, null)!!

        nickTxt.setText(nickName)
        addressTxt.setText(adress)


        var jsonString : String? = ""

        Thread{
            val url = URL("http://10.0.2.2:3001/post/mypost/${nickName}")

            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            BufferedReader(InputStreamReader(conn.inputStream)).use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    jsonString  = line

                }
            }
            val listview = findViewById<ListView>(R.id.mySentenceListView)
            val sentenceList = arrayListOf<ListViewModel>()
            val jArray = JSONArray(jsonString)
            var data = ArrayList<HashMap<String, String> >()
            for(i in 0 until jArray.length()){
                val jObject = jArray.getJSONObject(i)
                val nickName = jObject.getString("nickName")
                if(nickName.equals(""))break
                val title = jObject.getString("title");
                val content = jObject.getString("content")
                val postID = jObject.getString("postID")
                sentenceList.add(ListViewModel("ic_launcher_background", nickName, "정왕동",title,content))
                val element = HashMap<String, String>()
                element.put("title", title)
                element.put("content", content)
                element.put("nickName", nickName)
                element.put("address", "정왕동")
                element.put("postID", postID)
                data.add(element)
            }

            val sentenceAdapter = ListViewAdapter(this, sentenceList)
            listview.setOnItemClickListener { parent, view, position, id ->
                val showWriteIntent = Intent(this, ShowWriteActivity::class.java)
                showWriteIntent.putExtra("data", data)
                showWriteIntent.putExtra("index", position)
                startActivity(showWriteIntent)
            }
            listview.adapter = sentenceAdapter

        }.start()

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