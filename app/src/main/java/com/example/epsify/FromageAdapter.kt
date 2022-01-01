package com.example.epsify

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

class FromageAdapter(private val fromages: ArrayList<Fromage>): RecyclerView.Adapter<FromageAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fromage = fromages.get(position)
        holder.textViewTitle.text=fromage.name
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewFromageName)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_fromages, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fromages.size
    }
}
