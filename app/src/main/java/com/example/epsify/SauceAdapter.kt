package com.example.epsify

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso

class SauceAdapter(private val sauces: ArrayList<Sauce>): RecyclerView.Adapter<SauceAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sauce = sauces.get(position)
        holder.textViewTitle.text=sauce.name
        holder.textViewProductDescription.text=sauce.description

        Picasso.get().load(sauce.picture_url).into(holder.imageViewProduct)

    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewSauceName)
        val textViewProductDescription = view.findViewById<TextView>(R.id.textViewSauceDescription)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewSauce)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_sauces, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sauces.size
    }
}
