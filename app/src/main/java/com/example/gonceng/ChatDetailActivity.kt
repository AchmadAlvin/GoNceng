package com.example.gonceng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView

class ChatDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_detail)

        val name = intent.getStringExtra("driverName")
        val imageRes = intent.getIntExtra("driverImage", 0)

        findViewById<TextView>(R.id.tvDriverName).text = name
        findViewById<ImageView>(R.id.imgProfile).setImageResource(imageRes)

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
