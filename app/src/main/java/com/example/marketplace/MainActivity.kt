package com.example.marketplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() ,View.OnClickListener {
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.username)
        edtPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.loginbutton)

        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        var emptyEmail: Boolean = false
        var emptyPassword: Boolean = false

        if(edtEmail.text.toString().trim().isEmpty()){
            edtEmail.error = "Username Tidak Boleh Kosong!"
            emptyEmail = true
        }

        if(edtPassword.text.toString().trim().isEmpty()){
            edtPassword.error = "Password Tidak Boleh Kosong"
            emptyPassword = true
        }

        if(!emptyEmail && !emptyPassword){
            val dataReceived = Intent(this@MainActivity, MoveActivityWithData::class.java)
            val email = edtEmail.text.toString()
            dataReceived.putExtra("String", email)
            startActivity(dataReceived)
        }
    }
}