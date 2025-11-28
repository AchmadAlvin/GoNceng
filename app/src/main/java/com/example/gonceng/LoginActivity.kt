package com.example.gonceng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val backButton : ImageView = findViewById<ImageView>(R.id.back_button)
        val formEmail : EditText = findViewById<EditText>(R.id.form_email)
        val formPassword : EditText = findViewById<EditText>(R.id.form_password)
        val buttonLogin : Button = findViewById<Button>(R.id.button_login)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buttonLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            var emailData : String = "Achmad Alvin"
            var passwordData : String = "12345678"
            var inputEmail : String = formEmail.text.toString()
            var inputPassword : String = formPassword.text.toString()

            if (inputEmail == emailData && inputPassword == passwordData)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}