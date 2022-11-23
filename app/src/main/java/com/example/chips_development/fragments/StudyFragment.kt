package com.example.chips_development.fragments

import android.os.Bundle
import android.service.autofill.Validators.and
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.adapters.ShopsAdapter
import com.example.chips_development.adapters.StudyMainAdapter
import com.example.chips_development.data_classes.ShopsItems
import com.example.chips_development.data_classes.StudyMainItems


class StudyFragment : Fragment() {

    private lateinit var studyMainRecyclerView: RecyclerView
    private lateinit var themeMainArrayList: ArrayList<StudyMainItems>
    lateinit var themeMainId: Array<String>
//    lateinit var logoId: Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_study, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        themeMainId = arrayOf(
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1),
            getString(R.string.theme1)
        )

        studyMainRecyclerView = view.findViewById(R.id.recyclerViewStudyMain)
        studyMainRecyclerView.layoutManager = LinearLayoutManager(context)
        studyMainRecyclerView.setHasFixedSize(true)

        themeMainArrayList = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        for (i in themeMainId.indices) {
            val themesMain = StudyMainItems(themeMainId[i])
            themeMainArrayList.add(themesMain)
        }
        studyMainRecyclerView.adapter = StudyMainAdapter(themeMainArrayList)
    }
}