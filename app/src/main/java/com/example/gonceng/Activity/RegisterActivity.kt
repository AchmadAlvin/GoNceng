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
import com.example.gonceng.R
import com.example.gonceng.activity_account_created

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Membuat variable untuk mencari view pada layout dengan tipe dan idnya
        val backButton : ImageView = findViewById<ImageView>(R.id.back_button)
        val formEmail : EditText = findViewById<EditText>(R.id.form_email)
        val formUsername : EditText = findViewById<EditText>(R.id.form_username)
        val formPassword : EditText = findViewById<EditText>(R.id.form_password)
        val formConfirmPassword : EditText = findViewById<EditText>(R.id.form_password_confirm)
        val registerButton : Button = findViewById<Button>(R.id.btnCreateAccount)


        // object yang telah dibuat dan menggunakan fungsi setOnclickListener
        backButton.setOnClickListener {

            // Membuat variable intent yang memanggil konstruktor Intent
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // object yang telah dibuat dan menggunakan fungsi setOnclickListener
        registerButton.setOnClickListener {

            // membuat variabel untuk mengubah input menjadi string
            val inputEmail : String = formEmail.text.toString()
            val inputUsername : String = formUsername.text.toString()
            val inputPassword : String = formPassword.text.toString()
            val inputConfirmPassword : String = formConfirmPassword.text.toString()

            // jika input tidak kosong maka akan berpindah ke halaman account created
            if (inputEmail.isNotEmpty() && inputUsername.isNotEmpty() && inputPassword.isNotEmpty() && inputConfirmPassword.isNotEmpty()){

                // Membuat variable intent yang memanggil konstruktor Intent
                val intent = Intent(this, activity_account_created::class.java)
                startActivity(intent)
            } else {

                // jika input kosong maka akan muncul toast
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