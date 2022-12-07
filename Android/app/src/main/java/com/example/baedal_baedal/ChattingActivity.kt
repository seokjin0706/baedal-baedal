package com.example.baedal_baedal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import org.json.JSONArray
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

        val sendBtn = findViewById<Button>(R.id.chattingBtn)
        val editText = findViewById<EditText>(R.id.chattingEdit)


        var jsonString : String? = ""
        val chatView = findViewById<ListView>(R.id.chatListView)
        val chatList = arrayListOf<ListViewModel2>()

        Thread{
            val url = URL("http://10.0.2.2:3001/chat/" + intent.getStringExtra("postID"))

            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            BufferedReader(InputStreamReader(conn.inputStream)).use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    jsonString  = line
                }
            }


            val jArray = JSONArray(jsonString)
            for (i in 0 until jArray.length()) {
                val jObject = jArray.getJSONObject(i)
                if(jObject.getString("postID").equals("0")) break
                val sender = jObject.getString("sender");
                val message = jObject.getString("message")
                chatList.add(ListViewModel2(sender, message))
            }


            val chatAdapter = ChattingAdapter(this, chatList)
            chatView.adapter = chatAdapter

        }.start()


        sendBtn.setOnClickListener {
            val postData = "postID=${intent.getStringExtra("postID")}&title=${intent.getStringExtra("title")}&sender=$nickName&message=${editText.text}"

            Toast.makeText(this, "${editText.text}", Toast.LENGTH_SHORT).show()

            Thread{
                val url = URL("http://10.0.2.2:3001/chat/create")


                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.doOutput = true
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                conn.setRequestProperty("Content-Length", postData.length.toString())
                conn.useCaches = false

                DataOutputStream(conn.outputStream).use { it.writeBytes(postData) }
                BufferedReader(InputStreamReader(conn.inputStream)).use { br ->
                    var line: String?
                    while (br.readLine().also { line = it } != null) {
                        println(line)
                    }
                }
                finish()
                overridePendingTransition(0, 0)
                startActivity(intent)
                overridePendingTransition(0, 0)


            }.start()
        }
    }
}