package com.example.chips_development.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.data_classes.StudyMainItems


class StudyMainAdapter(private val themeMainList: ArrayList<StudyMainItems>) :
    RecyclerView.Adapter<StudyMainAdapter.StudyMainsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyMainsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_study_main,
            parent, false
        )
        return StudyMainsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudyMainsViewHolder, position: Int) {
        val currentItem = themeMainList[position]
        holder.themeMainName?.text = currentItem.themeMainName
//        holder.themeMainButton?.setImageResource(currentItem.themeMainButton)
    }

    override fun getItemCount(): Int {
        return themeMainList.size
    }

    class StudyMainsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var themeMainName: TextView? = null
//        var themeMainButton: ImageButton? = null

        init {
            themeMainName = itemView.findViewById(R.id.themeMainName)
//            themeMainButton = itemView.findViewById(R.id.themeMainButton)
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    themeMainName?.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}