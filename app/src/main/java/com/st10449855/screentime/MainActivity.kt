package com.st10449855.screentime

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var Openbutton: Button
    private lateinit var Exitbutton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        Openbutton = findViewById(R.id.button)
        Exitbutton = findViewById(R.id.button2)


        Openbutton.setOnClickListener {
            val intent = Intent(this,ActivityInput::class.java)
            startActivity(intent)
            finish()
        }
        Exitbutton.setOnClickListener {
            finish()
        }
    }
}