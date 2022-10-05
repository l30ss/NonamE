package com.fuji.noname.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fuji.noname.R
import com.fuji.noname.fragments.AboutFragment
import kotlinx.coroutines.NonCancellable.start


class LoginActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            // ทำการ findView
            val btnLogin = findViewById<Button>(R.id.btnLogin)
            val btnForgotPass = findViewById<Button>(R.id.btnFogotpassword)
            val btnRegister = findViewById<Button>(R.id.btnRegister)

            // การใส่ Event Click ให้กับปุ่ม btnForgotPass
            btnForgotPass.setOnClickListener {
                // การส่งเปลี่ยนหน้าจอ (intent)®
                val intent = Intent(this, FogotActivity::class.java)
                startActivity(intent)
                finish()

            }
            btnRegister.setOnClickListener {
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }
            btnLogin.setOnClickListener {
                val intent=Intent (this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }




