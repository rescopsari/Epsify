package com.example.epsify

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class StudentInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)
        val avatar = findViewById<ImageView>(R.id.student_picture)

        val student_intel : TextView = findViewById(R.id.student_intel)
        student_intel.setText(intent.getStringExtra("student_info"))
        val name : TextView = findViewById(R.id.name)
        name.setText(intent.getStringExtra("name"))
        val forname : TextView = findViewById(R.id.forname)
        forname.setText(intent.getStringExtra("forname"))
        val mail : TextView = findViewById(R.id.mail)
        mail.setText(intent.getStringExtra("mail"))
        val group : TextView = findViewById(R.id.group)
        group.setText(intent.getStringExtra("group"))
//        val avatar = intent.getStringExtra("avatar")

    }
}