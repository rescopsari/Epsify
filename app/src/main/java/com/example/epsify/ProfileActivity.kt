package com.example.epsify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView

class ProfileActivity : ToolbarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val textView: TextView = findViewById(R.id.textView5)
        textView.movementMethod = LinkMovementMethod.getInstance()

        showBtnBack()
    }
}