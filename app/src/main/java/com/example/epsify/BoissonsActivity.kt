package com.example.epsify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class BoissonsActivity : ToolbarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boissons)
        showBtnBack()

        val boissons = arrayListOf<Boisson>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewBoissons)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val boissonAdapter = BoissonAdapter(boissons)
        recyclerView.adapter = boissonAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/boissons.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {


            override fun onFailure(call: Call, e: IOException) {
                print("fail")
//                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {

                val data = response.body?.string()
                if(data !=null){
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")

                    for(i in 0 until jsArray.length()){
                        val jsBoisson = jsArray.getJSONObject(i)
                        val name =jsBoisson.optString("name","")
                        val description = jsBoisson.optString("description", "")
                        val picture_url = jsBoisson.optString("picture_url", "")
                        val boisson = Boisson(name, description, picture_url)
                        boissons.add(boisson)
                    }
                    runOnUiThread(Runnable {
                        boissonAdapter.notifyDataSetChanged()
                    })
                    Handler(Looper.getMainLooper()).post(Runnable {
                        boissonAdapter.notifyDataSetChanged()
                    })
                    Log.d("WS",data)
                    Log.d("Student","${boissons.size}")
                }
            }
        })
    }
}