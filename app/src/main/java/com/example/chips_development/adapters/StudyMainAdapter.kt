package com.example.chips_development.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.data_classes.StudyMainItems
import com.squareup.picasso.Picasso


class StudyMainAdapter(private val themeMainList: ArrayList<StudyMainItems>) :
    RecyclerView.Adapter<StudyMainAdapter.StudyMainsViewHolder>() {

    private val collapseMap = HashMap<String, Boolean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyMainsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_study_main,
            parent, false
        )
        return StudyMainsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudyMainsViewHolder, position: Int) {
        val currentItem = themeMainList[position]
        holder.themeMainName.text = currentItem.name
        holder.themeSecondName.text = currentItem.themes

        val isCollapsed = collapseMap.getOrDefault(currentItem.themes, false)
        holder.themeSecondName.isVisible = isCollapsed
        holder.themeMainButton.setImageResource(
            if (isCollapsed) R.drawable.ic_baseline_arrow_drop_up_24
            else R.drawable.ic_baseline_arrow_drop_down_24
        )
        holder.goToTheme.isVisible = isCollapsed

        holder.themeMainButton.setOnClickListener {
            val wasCollapsed = collapseMap.getOrDefault(currentItem.themes, false)
            holder.themeSecondName.isVisible = !wasCollapsed
            holder.goToTheme.isVisible = !wasCollapsed
            collapseMap[currentItem.themes] = !wasCollapsed
            holder.themeMainButton.setImageResource(
                if (wasCollapsed) R.drawable.ic_baseline_arrow_drop_down_24
                else {
                    R.drawable.ic_baseline_arrow_drop_up_24
                }
            )
            if (wasCollapsed) {
                holder.lessonTextStart.isVisible = false
                holder.lessonTextMid.isVisible = false
                holder.lessonImageStart.isVisible = false
                holder.lessonImageMid.isVisible = false
                holder.finishLesson.isVisible = false
            }
        }

        holder.themeState.text = currentItem.state
        if (holder.themeState.text == "true") {
//            holder.goToTheme.setBackgroundResource(R.color.black)
            holder.goToTheme.text = "Restart"
        } else {
//            holder.goToTheme.setBackgroundResource(R.color.white)
            holder.goToTheme.text = "Start"
        }
        holder.lessonTextStart.isVisible = false
        holder.lessonTextMid.isVisible = false
        holder.lessonImageStart.isVisible = false
        holder.lessonImageMid.isVisible = false
        holder.finishLesson.isVisible = false

        holder.goToTheme.setOnClickListener {
            holder.lessonTextStart.text = currentItem.lessonTextStart
            holder.lessonTextMid.text = currentItem.lessonTextMid
            Picasso.get().load(currentItem.lessonImageStart).into(holder.lessonImageStart)
            Picasso.get().load(currentItem.lessonImageMid).into(holder.lessonImageMid)

            checkVisible(holder)
        }

        holder.finishLesson.setOnClickListener {
            checkVisible(holder)
            holder.goToTheme.text = "Restart"
        }
    }

    private fun checkVisible(holder: StudyMainsViewHolder) {
        if (
            !holder.lessonTextStart.isVisible and
            !holder.lessonTextMid.isVisible and
            !holder.lessonImageStart.isVisible and
            !holder.lessonImageMid.isVisible and
            !holder.finishLesson.isVisible
        ) {
            holder.lessonTextStart.isVisible = true
            holder.lessonTextMid.isVisible = true
            holder.lessonImageStart.isVisible = true
            holder.lessonImageMid.isVisible = true
            holder.finishLesson.isVisible = true
        } else {
            holder.lessonTextStart.isVisible = false
            holder.lessonTextMid.isVisible = false
            holder.lessonImageStart.isVisible = false
            holder.lessonImageMid.isVisible = false
            holder.finishLesson.isVisible = false
        }
    }

    override fun getItemCount(): Int {
        return themeMainList.size
    }

    class StudyMainsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val themeMainName: TextView = itemView.findViewById(R.id.themeMainName)
        val themeSecondName: TextView = itemView.findViewById(R.id.themeSecondName)
        val themeMainButton: ImageButton = itemView.findViewById(R.id.themeMainButton)
        val themeState: TextView = itemView.findViewById(R.id.themeState)
        val goToTheme: Button = itemView.findViewById(R.id.goToTheme)

        val lessonTextStart: TextView = itemView.findViewById(R.id.lessonTextStart)
        val lessonTextMid: TextView = itemView.findViewById(R.id.lessonTextMid)
        val lessonImageStart: ImageView = itemView.findViewById(R.id.lessonImageStart)
        val lessonImageMid: ImageView = itemView.findViewById(R.id.lessonImageMid)

        val finishLesson: Button = itemView.findViewById(R.id.finishLesson)
    }
}