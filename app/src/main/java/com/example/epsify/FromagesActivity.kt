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

class FromagesActivity : ToolbarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fromages)
        showBtnBack()

        val fromages = arrayListOf<Fromage>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFromages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val fromageAdapter = FromageAdapter(fromages)
        recyclerView.adapter = fromageAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/fromage.json"
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
                        val jsFromage = jsArray.getJSONObject(i)
                        val name =jsFromage.optString("name","")
                        val description = jsFromage.optString("description", "")
                        val picture_url = jsFromage.optString("picture_url", "")
                        val fromage = Fromage(name, description, picture_url)
                        fromages.add(fromage)
                    }
                    runOnUiThread(Runnable {
                        fromageAdapter.notifyDataSetChanged()
                    })
                    Handler(Looper.getMainLooper()).post(Runnable {
                        fromageAdapter.notifyDataSetChanged()
                    })
                    Log.d("WS",data)
                    Log.d("Student","${fromages.size}")
                }
            }
        })
    }
}