package com.example.epsify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
//        showBtnBack()
//        setHeaderTitle(getString(R.string.txt_home_student_online))
        val products = arrayListOf<Product>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if(data !=null){
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")
                    Log.d(jsArray)

                    for(i in 0 until jsArray.length()){
                        val jsProduct = jsArray.getJSONObject(i)
                        val name =jsProduct.optString("name","")
                        val description =jsProduct.optString("description","")
                        val picture_url =jsProduct.optString("picture_url","")

                        val product = Product(name, description, imgUrl = picture_url)
                        products.add(product)
                        Log.d("Product",product.name)
                    }
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })

//                    Handler(Looper.getMainLooper()).post(Runnable {
//                        studentAdapter.notifyDataSetChanged()
//                    })

                    Log.d("WS",data)
                    Log.d("Product","${products.size}")
                }
            }
        })


    }
}