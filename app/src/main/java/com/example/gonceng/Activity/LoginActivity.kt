package com.example.gonceng.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.Activity.HomeActivity
import com.example.gonceng.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
//      Inisiasi variable pada layout
        val backButton = findViewById<ImageView>(R.id.back_button)
        val formEmail = findViewById<EditText>(R.id.form_email)
        val formPassword = findViewById<EditText>(R.id.form_password)
        val buttonLogin = findViewById<Button>(R.id.button_login)
//      membuat lompatan back button untuk kembali ke onboarding
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//      membuat lompatan agar menuju ke halaman home activity
        buttonLogin.setOnClickListener {
//          inisiasi intent
            val intent = Intent(this, HomeActivity::class.java)
//          data dari email data static
            var emailData : String = "Achmad@email.com"
//          data dari password data static
            var passwordData : String = "12345678"
//          inisiasi agar input edit text email menjadi string
            var inputEmail : String = formEmail.text.toString()
//          inisiasi agar input edit text password menjadi string
            var inputPassword : String = formPassword.text.toString()
//          ketika yang diinputkan user dengan data static diatas maka lompat ke halaman homeactivity
            if (inputEmail == emailData && inputPassword == passwordData){
                startActivity(intent)
//          jika tidak maka akan ada toast itu textnya bisa dilihat sendiri
            } else {
                Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}