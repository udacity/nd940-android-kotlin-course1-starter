package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to the login views
        val username = findViewById<EditText>(R.id.shoe_username)
        val password = findViewById<EditText>(R.id.shoe_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnRegister = findViewById<Button>(R.id.btn_register)
//
//        btnLogin.setOnClickListener{
//            val username = username.text
//            val password = password.text
//            Toast.makeText(this@MainActivity, username, Toast.LENGTH_LONG).show()
//        }
//        // set onClickListener on the register button
//        btnRegister.setOnClickListener{
//            val username = username.text
//            val password = password.text
//            Toast.makeText(this@MainActivity, username, Toast.LENGTH_LONG).show()
//        }
    }

}
