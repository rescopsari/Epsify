package com.example.epsify

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso

class ProductAdapter(private val products: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){



    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewProductName)
        val textViewProductDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_products, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.textViewTitle.text=product.name
        holder.textViewProductDescription.text=product.description

        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)

    }

    override fun getItemCount(): Int {
        return products.size
    }
}
