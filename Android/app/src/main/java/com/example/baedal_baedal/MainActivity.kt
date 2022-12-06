package com.example.baedal_baedal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import com.example.baedal_baedal.databinding.ActivityLoginBinding
import com.example.baedal_baedal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signUpIntent = Intent(this, SignUpActivity::class.java)
        val mainInterfaceActivity = Intent(this, MainInterfaceActivity::class.java)

        // 회원가입 폼 이동
        binding.signUpBtn.setOnClickListener {
            startActivity(signUpIntent)
        }

        binding.loginBtn.setOnClickListener {
            // 로그인되면 가는 페이지
            startActivity(mainInterfaceActivity)
        }
    }
}