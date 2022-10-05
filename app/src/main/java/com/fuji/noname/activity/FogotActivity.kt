package com.fuji.noname.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.fuji.noname.R

class FogotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fogot)


        //findView
        val btnbackLogin = findViewById<Button>(R.id.btnbackLogin)




        // การใส่ Event Click ให้กับปุ่ม btnForgotPass
        btnbackLogin.setOnClickListener {
            // การส่งเปลี่ยนหน้าจอ (intent)
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            // Finish () เป็นการปิดจอไม่ให้เปิดค้างไว้
            finish()
        }





    }
}