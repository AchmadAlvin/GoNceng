package com.example.gonceng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.Activity.HomeActivity

class activity_account_created : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account_created)

        // Membuat variable untuk mencari view pada layout dengan tipe dan idnya.
        val okeButton : Button = findViewById<Button>(R.id.CreatedOke)

        // object dari variable yang telah dibuat dan menggunakan fungsi setOnclickListener
        okeButton.setOnClickListener {
            // Membuat variable intent yang memanggil konstruktor Intent
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}