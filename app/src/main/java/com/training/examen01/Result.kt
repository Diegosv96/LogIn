package com.training.examen01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var resultText : TextView
private lateinit var botonReset : Button

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        resultText = findViewById(R.id.resultText)
        botonReset = findViewById(R.id.botonReset)
    }

    private fun initListeners() {
        botonReset.setOnClickListener{
            val int = Intent(this, MainActivity::class.java)
            startActivity(int)
        }
    }

    private fun initUI(){
        val user = intent.extras?.getString("user").orEmpty()
        val pass = intent.extras?.getString("pass").orEmpty()
        resultText.text = "Bienvenido $user, tu contraseña es: $pass"
    }

}