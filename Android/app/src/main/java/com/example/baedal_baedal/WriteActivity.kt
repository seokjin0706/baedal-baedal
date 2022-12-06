package com.example.baedal_baedal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class WriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val regBtn = findViewById<Button>(R.id.reg_button)

        val mainInterfaceActivityIntent = Intent(this, MainInterfaceActivity::class.java)

        regBtn.setOnClickListener {
            startActivity(mainInterfaceActivityIntent)
            Toast.makeText(this, "작성 확인ㅇㅋ", Toast.LENGTH_SHORT).show()
        }
    }
}