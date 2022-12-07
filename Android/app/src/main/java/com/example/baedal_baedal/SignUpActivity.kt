package com.example.baedal_baedal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.example.baedal_baedal.databinding.ActivitySingUpBinding
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val loginIntent = Intent(this, MainActivity::class.java)



        binding.signUpBtn2.setOnClickListener {
            val id = binding.idEdit.text.toString()
            val passwd = binding.passwdEdit.text.toString()
            val name = binding.nameEdit.text.toString()
            val phone = binding.phoneEdit.text.toString()
            val add = binding.addressEdit.text.toString()
            val nick = binding.nicknameEdit.text.toString()

            val postData = "userID=$id&passWord=$passwd&userName=$name&phoneNumber=$phone&address=$add&nickName=$nick"


            Thread{
                val url = URL("http://10.0.2.2:3001/user/create")


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
            }.start()

            startActivity(loginIntent)
            Toast.makeText(this, "회원가입을 축하합니다!!", Toast.LENGTH_SHORT).show()
        }

        binding.resetBtn.setOnClickListener {
            binding.idEdit.setText(null)
            binding.passwdEdit.setText(null)
            binding.nameEdit.setText(null)
            binding.phoneEdit.setText(null)
            binding.addressEdit.setText(null)
            binding.nicknameEdit.setText(null)
        }
    }
}