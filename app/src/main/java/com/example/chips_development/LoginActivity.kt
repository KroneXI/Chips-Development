package com.example.chips_development

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private var login: EditText? = null
    private var password: EditText? = null
    private var btLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById(R.id.login)
        password = findViewById(R.id.password)
        btLogin = findViewById(R.id.btLogin)

        btLogin?.setOnClickListener {
            if (login?.text.toString() == "root" && password?.text.toString() == "toor") {
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 100)
            }
        }
    }
}