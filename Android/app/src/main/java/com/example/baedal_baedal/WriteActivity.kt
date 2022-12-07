package com.example.baedal_baedal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WriteActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var PREFS_KEY = "prefs"
    var nickName_KEY = "nickName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val regBtn = findViewById<Button>(R.id.reg_button)
        val title_et = findViewById<EditText>(R.id.title_et)
        val content_et = findViewById<EditText>(R.id.content_et)

        val mainInterfaceActivityIntent = Intent(this, MainInterfaceActivity::class.java)

        regBtn.setOnClickListener {
            sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
            var nickName = sharedPreferences.getString(nickName_KEY, null)!!

            var title = title_et.text.toString()
            var content = content_et.text.toString()
            Log.d("MMMM", "WriteActivity - regBtn - $nickName  $title  $content")

            val postData = "title=$title&content=$content&nickName=$nickName"

            Thread{
                val url = URL("http://localhost:3001/post/create")


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
                        //println(line)
                    }
                }
            }.start()

            startActivity(mainInterfaceActivityIntent)
            Toast.makeText(this, "작성 성공인지 실패인지 모르겠당 암튼 ㅇㅋ", Toast.LENGTH_SHORT).show()
        }
    }
}