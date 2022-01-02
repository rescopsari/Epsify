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

class SaucesActivity : ToolbarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sauce)
        showBtnBack()

        val sauces = arrayListOf<Sauce>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSauces)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val sauceAdapter = SauceAdapter(sauces)
        recyclerView.adapter = sauceAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/sauce.json"
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
                        val jsProduct = jsArray.getJSONObject(i)
                        val name =jsProduct.optString("name","")
                        val description = jsProduct.optString("description", "")
                        val picture_url = jsProduct.optString("picture_url", "")
                        val sauce = Sauce(name, description, picture_url)
                        sauces.add(sauce)
                    }
                    runOnUiThread(Runnable {
                        sauceAdapter.notifyDataSetChanged()
                    })
                    Handler(Looper.getMainLooper()).post(Runnable {
                        sauceAdapter.notifyDataSetChanged()
                    })
                    Log.d("WS",data)
                    Log.d("Student","${sauces.size}")
                }
            }
        })
    }
}