package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
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
    var address_KEY = "address"
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
        var address = sharedPreferences.getString(address_KEY, null)!!
        var nickName = sharedPreferences.getString(nickName_KEY, null)!!
        Log.d("MMMM", "MainInterface - $userID  $passWord  $userName  $phoneNumber  $address  $nickName")

        val writeBtn = findViewById<Button>(R.id.writeBtn)
        val chatBtn = findViewById<Button>(R.id.chatBtn)
        val myPageBtn = findViewById<Button>(R.id.myPageBtn)

        val writeIntent = Intent(this, WriteActivity::class.java)
        val chatIntent = Intent(this, ChatActivity::class.java)
        val myPageIntent = Intent(this, MyPageActivity::class.java)
        var jsonString : String? = ""

        var location = arrayOf("정왕1동", "정왕2동", "정왕3동", "정왕4동")
        var spinner = findViewById<Spinner>(R.id.spinner)
        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, location)
        spinner.adapter = adapter

        var food = arrayOf("보쌈", "족발", "돈까스", "피자", "치킨", "중식", "양식", "일식", "한식")
        var spinner1 = findViewById<Spinner>(R.id.spinner2)
        var adapter1: ArrayAdapter<String>
        adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, location)
        spinner1.adapter = adapter1

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
            var data = ArrayList<HashMap<String, String> >()
            for(i in 0 until jArray.length()){
                val jObject = jArray.getJSONObject(i)
                val title = jObject.getString("title");
                val content = jObject.getString("content")
                val nickName = jObject.getString("nickName")
                sentenceList.add(ListViewModel("ic_launcher_background", nickName, "정왕동",title,content))
                val element = HashMap<String, String>()
                element.put("title", title)
                element.put("content", content)
                element.put("nickName", nickName)
                element.put("address", "정왕동")
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