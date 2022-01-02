package com.example.epsify

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso

class FromageAdapter(private val fromages: ArrayList<Fromage>): RecyclerView.Adapter<FromageAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fromage = fromages.get(position)
        holder.textViewTitle.text=fromage.name
        holder.textViewProductDescription.text=fromage.description

        Picasso.get().load(fromage.picture_url).into(holder.imageViewProduct)

    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewProductName)
        val textViewProductDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_fromages, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fromages.size
    }
}
