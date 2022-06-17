package com.example.login2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EsperaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_espera)
        val inicio = findViewById<Button>(R.id.inicio)

        inicio.setOnClickListener {
            setContentView(R.layout.activity_apiactivity)
        }
    }

}