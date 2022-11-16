package com.example.chips_development.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.data_classes.ShopsItems

class ShopsAdapter(private val shopsList: ArrayList<ShopsItems>) :
    RecyclerView.Adapter<ShopsAdapter.ShopsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_shops,
            parent, false
        )
        return ShopsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShopsViewHolder, position: Int) {
        val currentItem = shopsList[position]
        holder.shopsName.text = currentItem.shopsName
        holder.shopsLink.text = currentItem.shopsLink
        holder.shopsLogo.setImageResource(currentItem.shopsLogo)
    }

    override fun getItemCount(): Int {
        return shopsList.size
    }

    class ShopsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shopsName: TextView = itemView.findViewById(R.id.shopsName)
        val shopsLink: TextView = itemView.findViewById(R.id.shopsLink)
        val shopsLogo: ImageView = itemView.findViewById(R.id.shopsLogo)
    }
}