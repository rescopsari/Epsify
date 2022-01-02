package com.example.epsify

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso

class SurgeleAdapter(private val surgeles: ArrayList<Surgele>): RecyclerView.Adapter<SurgeleAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val surgele = surgeles.get(position)
        holder.textViewTitle.text=surgele.name
        holder.textViewProductDescription.text=surgele.description

        Picasso.get().load(surgele.picture_url).into(holder.imageViewProduct)

    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewSurgeleName)
        val textViewProductDescription = view.findViewById<TextView>(R.id.textViewSurgeleDescription)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewSurgele)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_surgeles, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return surgeles.size
    }
}
