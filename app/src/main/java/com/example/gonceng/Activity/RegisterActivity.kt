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
import com.example.gonceng.Activity.MainActivity
import com.example.gonceng.R
import com.example.gonceng.activity_account_created

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        val backButton : ImageView = findViewById<ImageView>(R.id.back_button)
        val formEmail : EditText = findViewById<EditText>(R.id.form_email)
        val formUsername : EditText = findViewById<EditText>(R.id.form_username)
        val formPassword : EditText = findViewById<EditText>(R.id.form_password)
        val formConfirmPassword : EditText = findViewById<EditText>(R.id.form_password_confirm)
        val registerButton : Button = findViewById<Button>(R.id.btnCreateAccount)



        backButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val inputEmail : String = formEmail.text.toString()
            val inputUsername : String = formUsername.text.toString()
            val inputPassword : String = formPassword.text.toString()
            val inputConfirmPassword : String = formConfirmPassword.text.toString()
            if (inputEmail.isNotEmpty() && inputUsername.isNotEmpty() && inputPassword.isNotEmpty() && inputConfirmPassword.isNotEmpty()){
                val intent = Intent(this, activity_account_created::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Data Harus Diisi", Toast.LENGTH_SHORT).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}