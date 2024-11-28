package com.training.examen01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var usernameText : EditText
private lateinit var passwordText : EditText
private lateinit var botonLogin : Button

private var username : String = ""
private var password : String = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        usernameText = findViewById(R.id.username)
        passwordText = findViewById(R.id.password)
        botonLogin = findViewById(R.id.botonLogin)
    }

    private fun initListeners() {
        botonLogin.setOnClickListener{
            username = usernameText.text.toString()
            password = passwordText.text.toString()

            val intent = Intent(this, Result::class.java)
            intent.putExtra("user", username)
            intent.putExtra("pass", password)

            startActivity(intent)
        }
    }

    private fun initUI(){
    }
}