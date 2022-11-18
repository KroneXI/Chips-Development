package com.example.chips_development.adapters

import android.content.Intent
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        holder.shopsName?.text = currentItem.shopsName
        holder.shopsLink?.text = currentItem.shopsLink
        holder.shopsLogo?.setImageResource(currentItem.shopsLogo)
    }

    override fun getItemCount(): Int {
        return shopsList.size
    }

    class ShopsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var shopsName: TextView? = null
        var shopsLink: TextView? = null
        var shopsLogo: ImageView? = null

        init {
            shopsName = itemView.findViewById(R.id.shopsName)
            shopsLink = itemView.findViewById(R.id.shopsLink)
//            shopsLink?.movementMethod = LinkMovementMethod.getInstance()
            shopsLogo = itemView.findViewById(R.id.shopsLogo)

            itemView.setOnClickListener {
//                itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(shopsName?.text.toString())))
                Toast.makeText(
                    itemView.context,
                    shopsLink?.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}