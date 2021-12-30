package com.example.epsify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonZone1: Button = findViewById(R.id.buttonZone1)

        buttonZone1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,GroupActivity::class.java)
            startActivity(newIntent)
        })

        val buttonZone2: Button = findViewById(R.id.buttonZone2)

        buttonZone2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,ProductsActivity::class.java)
            startActivity(newIntent)
        })
    }
}