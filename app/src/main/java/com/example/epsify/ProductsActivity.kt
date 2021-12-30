package com.example.epsify

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import android.os.Handler
import android.os.Looper


class ProductsActivity : ToolbarActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val products = arrayListOf<Products>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productsAdapter = ProductsAdapter(products)
        recyclerView.adapter = productsAdapter


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
                val products = arrayListOf<Products>()
                val data = response.body?.string()
                if(data !=null){
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")

                    for(i in 0 until jsArray.length()){
                        val jsProducts = jsArray.getJSONObject(i)
                        val title =jsProducts.optString("title","")
                        val products_url = jsProducts.optString("products_url", "")
                        val category_id = jsProducts.optString("category_id", "")

                        products.add(Products(title, products_url, category_id))


                        println(title)

                    }
                    runOnUiThread(Runnable {
                        productsAdapter.notifyDataSetChanged()
                    })
                    Handler(Looper.getMainLooper()).post(Runnable {
                        productsAdapter.notifyDataSetChanged()
                    })

                }
            }
        })
    }
}