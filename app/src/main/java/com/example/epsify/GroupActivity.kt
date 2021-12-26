package com.example.epsify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupActivity : ToolbarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        val buttonJason: Button = findViewById(R.id.buttonZone1)

        buttonJason.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,ProfileActivity::class.java)
            startActivity(newIntent)
        })

        val buttonAlex: Button = findViewById(R.id.buttonZone2)

        buttonAlex.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,ProfileActivity::class.java)
            startActivity(newIntent)
        })

        val buttonJohn: Button = findViewById(R.id.buttonZone3)

        buttonJohn.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,ProfileActivity::class.java)
            startActivity(newIntent)
        })

        showBtnBack()
    }
}