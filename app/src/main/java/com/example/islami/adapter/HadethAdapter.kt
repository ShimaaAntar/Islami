package com.example.islami.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.ItemHadethBinding
import com.example.islami.model.Hadeth

class HadethAdapter(val items:List<Hadeth>):RecyclerView.Adapter<HadethAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val hadethName:TextView?=itemView.findViewById(R.id.hadeth_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val HadethName=items.get(position)
        holder.hadethName?.setText(HadethName.title)
        if (onItemsClickListener!=null){
            holder.itemView.setOnClickListener{
                onItemsClickListener?.onItemClick(position, HadethName)
            }
        }

        }
    var onItemsClickListener:OnItemsClickListener?=null
    interface OnItemsClickListener{
        fun onItemClick(position: Int,model:Hadeth)
    }

    override fun getItemCount(): Int {
        return items.size
    }



}