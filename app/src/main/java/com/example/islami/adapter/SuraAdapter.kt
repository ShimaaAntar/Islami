package com.example.islami.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class SuraAdapter(val items:List<String> ):RecyclerView.Adapter<SuraAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val suraName:TextView=itemView.findViewById(R.id.sure_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sura,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val SuraName=items.get(position)
        holder.suraName.setText(SuraName)
        if (onItemsClickListener!=null){
            holder.itemView.setOnClickListener{
                onItemsClickListener?.onItemClick(position,SuraName)
            }
        }
    }
    var onItemsClickListener: OnItemsClickListener?=null
    interface OnItemsClickListener{
        fun onItemClick(position: Int, name:String)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}