package com.example.baedal_baedal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.se.omapi.Session
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.baedal_baedal.databinding.ActivityLoginBinding
import com.example.baedal_baedal.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    /*[{"result":"success", "userID":string, "passWord": string ,"userName": string ,"phoneNumber": string ,"address": string ,"NickName": string}]*/
    lateinit var sharedPreferences: SharedPreferences
    var PREFS_KEY = "prefs"
    var result_KEY = "result"
    var userID_KEY = "userID"
    var passWord_KEY = "passWord"
    var userName_KEY = "userName"
    var phoneNumber_KEY = "phoneNumber"
    var address_KEY = "address"
    var nickName_KEY = "nickName"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signUpIntent = Intent(this, SignUpActivity::class.java)
        val mainInterfaceActivity = Intent(this, MainInterfaceActivity::class.java)

        // 세션
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        var result = ""
        var userID = ""
        var passWord = ""
        var userName =  ""
        var phoneNumber =  ""
        var address =  ""
        var nickName =  ""


        // 회원가입 폼 이동
        binding.signUpBtn.setOnClickListener {
            startActivity(signUpIntent)
        }

        binding.loginBtn.setOnClickListener {
            val id = binding.loginIdEdit.text.toString()
            val passwd = binding.loginPasswdEdit.text.toString()

            val postData = "userID=$id&passWord=$passwd"

            Thread{
                val url = URL("http://localhost:3001/user/login")

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
                        val jsonString = line
                        val jObject = JSONObject(jsonString)
                        result = jObject.getString("result")
                        if(result.equals("fail")) break
                        userID = jObject.getString("userID")
                        passWord = jObject.getString("passWord")
                        userName = jObject.getString("userName")
                        phoneNumber = jObject.getString("phoneNumber")
                        address = jObject.getString("address")
                        nickName = jObject.getString("nickName")
                        Log.d("MMMM", "값 받아온거 확인 - $userID  $passWord  $userName  $phoneNumber  $address  $nickName")
                        /*[{"result":"success", "userID":string, "passWord": string ,"userName": string ,"phoneNumber": string ,"address": string ,"nickName": string}]*/

                        Log.d("MMMM", "success하면 - $userID  $passWord  $userName  $phoneNumber  $address  $nickName")
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        Log.d("MMMM", "$userID  $passWord  $userName  $phoneNumber  $address  $nickName")
                        editor.putString(userID_KEY, userID)
                        editor.putString(passWord_KEY, passWord)
                        editor.putString(userName_KEY, userName)
                        editor.putString(phoneNumber_KEY, phoneNumber)
                        editor.putString(address_KEY, address)
                        editor.putString(nickName_KEY, nickName)

                        editor.apply()

                        startActivity(mainInterfaceActivity)
                    }
                }
            }.start()
            if (id == null || passwd == null) {
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}