package com.example.gonceng.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Membuat variable untuk mencari view pada layout dengan tipe dan idnya
        val btnlogin = findViewById<Button>(R.id.btnLogin)
        val buttonregister = findViewById<Button>(R.id.btnRegister)

        // object dari variable yang telah dibuat dan menggunakan fungsi setOnclickListener
        btnlogin.setOnClickListener {
            // Membuat variable intent yang memanggil konstruktor Intent
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonregister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }
    }
}