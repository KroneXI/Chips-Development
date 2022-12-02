package com.example.chips_development.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.data_classes.ShopsItems
import com.squareup.picasso.Picasso


class ShopsAdapter(private val shopsList: ArrayList<ShopsItems>) :
    RecyclerView.Adapter<ShopsAdapter.ShopsViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(link: String)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_shops,
            parent, false
        )
        return ShopsViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ShopsViewHolder, position: Int) {
        val shopsItem = shopsList[position]
        holder.shopsName.text = shopsItem.shopsName
        holder.shopsLink.text = shopsItem.shopsLink
        Picasso.get().load(shopsItem.shopsLogo).into(holder.shopsLogo)
    }

    override fun getItemCount(): Int {
        return shopsList.size
    }

    class ShopsViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val shopsName: TextView = itemView.findViewById(R.id.shopsName)
        val shopsLink: TextView = itemView.findViewById(R.id.shopsLink)
        val shopsLogo: ImageView = itemView.findViewById(R.id.shopsLogo)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(shopsLink.text.toString())
            }
        }
    }
}