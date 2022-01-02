package com.example.epsify

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button


class RayonsActivity : ToolbarActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayons)



        val buttonTestBoissons: Button = findViewById(R.id.testBoissons)

        buttonTestBoissons.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,ProductsActivity::class.java)
            startActivity(newIntent)
        })

        val buttonTestFromages: Button = findViewById(R.id.testFromages)

        buttonTestFromages.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,FromagesActivity::class.java)
            startActivity(newIntent)
        })

        val buttonTestSurgele: Button = findViewById(R.id.testSurgele)

        buttonTestSurgele.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,SurgeleActivity::class.java)
            startActivity(newIntent)
        })

        val buttonTestSauce: Button = findViewById(R.id.testSauce)

        buttonTestSauce.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,SaucesActivity::class.java)
            startActivity(newIntent)
        })


        showBtnBack()
    }
}

