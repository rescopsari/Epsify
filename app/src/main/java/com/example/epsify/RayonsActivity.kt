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
            val newIntent = Intent(application,BoissonsActivity::class.java)
            startActivity(newIntent)
        })

        val buttonTestFromages: Button = findViewById(R.id.testFromages)

        buttonTestFromages.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,FromagesActivity::class.java)
            startActivity(newIntent)
        })


        showBtnBack()

        val rayons = arrayListOf<Rayon>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRayons)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val rayonAdapter = RayonAdapter(rayons)
        recyclerView.adapter = rayonAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback{


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
                        val jsRayon = jsArray.getJSONObject(i)
                        val title =jsRayon.optString("title","")
                        val products_url = jsRayon.optString("products_url", "")
                        val category_id = jsRayon.optString("category_id", "")
                        val rayon = Rayon(title, products_url, category_id)
                        rayons.add(rayon)
                    }
                    runOnUiThread(Runnable {
                        rayonAdapter.notifyDataSetChanged()
                    })
                    Handler(Looper.getMainLooper()).post(Runnable {
                        rayonAdapter.notifyDataSetChanged()
                    })
                    Log.d("WS",data)
                    Log.d("Student","${rayons.size}")
                }
            }
        })
    }
}

//val btn = arrayListOf<rayons>()
//val btnSize = rayons.size
//for (btn in 0..btnSize) {
//    println(btn)
////                        btn[i] = Button(this)
////                        btn[i]!!.id = i
////                        btn[i]!!.text = "dynamic buttion $i"
////                        ll.addView(btn[i])
////                        btn[i]!!.setOnClickListener {
////                            //your desired functionality
////                        }
//}