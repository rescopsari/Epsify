package com.example.epsify

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

class BoissonAdapter(private val boissons: ArrayList<Boisson>): RecyclerView.Adapter<BoissonAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val boisson = boissons.get(position)
        holder.textViewTitle.text=boisson.name
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewBoissonName)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_boissons, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return boissons.size
    }
}
