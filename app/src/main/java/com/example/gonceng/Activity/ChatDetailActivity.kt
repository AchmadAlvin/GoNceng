package com.example.gonceng.Activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gonceng.R

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