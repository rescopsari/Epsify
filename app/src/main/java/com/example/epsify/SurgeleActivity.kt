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

class SurgeleActivity : ToolbarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surgele)
        showBtnBack()

        val surgeles = arrayListOf<Surgele>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSurgeles)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val surgeleAdapter = SurgeleAdapter(surgeles)
        recyclerView.adapter = surgeleAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/frozen.json"
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
                        val jsSurgele = jsArray.getJSONObject(i)
                        val name =jsSurgele.optString("name","")
                        val description = jsSurgele.optString("description", "")
                        val picture_url = jsSurgele.optString("picture_url", "")
                        val surgele = Surgele(name, description, picture_url)
                        surgeles.add(surgele)
                    }
                    runOnUiThread(Runnable {
                        surgeleAdapter.notifyDataSetChanged()
                    })
                    Handler(Looper.getMainLooper()).post(Runnable {
                        surgeleAdapter.notifyDataSetChanged()
                    })
                    Log.d("WS",data)
                    Log.d("Student","${surgeles.size}")
                }
            }
        })
    }
}