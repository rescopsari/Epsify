package com.example.epsify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

open class ToolbarActivity : AppCompatActivity() {
    fun showBtnBack() {
        val left_icon = findViewById<ImageView>(R.id.left_icon)
        left_icon.visibility= View.VISIBLE

        left_icon.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}