package com.example.chips_development.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.chips_development.R

class MainFragment : Fragment() {

//    todo: внеси изменения как в HelpFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_main, container, false)
        val button = view.findViewById<Button>(R.id.buttonToHelp)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_helpFragment)
        }

        return view
    }

//    companion object {}
}