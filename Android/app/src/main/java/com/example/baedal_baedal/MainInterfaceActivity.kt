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
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


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

        val showWriteIntent = Intent(this, ShowWriteActivity::class.java)
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
        var jsonString : String? = ""

        Thread{
            val url = URL("http://10.0.2.2:3001/post")

            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
             BufferedReader(InputStreamReader(conn.inputStream)).use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    jsonString  = line

                }
            }
            val listview = findViewById<ListView>(R.id.sentenceListView)
            val sentenceList = arrayListOf<ListViewModel>()
            val jArray = JSONArray(jsonString)
            for(i in 0 until jArray.length()){
                val jObject = jArray.getJSONObject(i)
                val title = jObject.getString("title");
                val content = jObject.getString("content")
                val nickName = jObject.getString("nickName")
                sentenceList.add(ListViewModel("ic_launcher_background", nickName, "정왕동",title,content))

            }

            val sentenceAdapter = ListViewAdapter(this, sentenceList)
            listview.setOnItemClickListener { parent, view, position, id ->

                startActivity(showWriteIntent)


            }

            listview.adapter = sentenceAdapter

        }.start()


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