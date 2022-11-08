package com.example.chips_development

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HelpFragment : Fragment() {

//    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_help, container, false)

        val button = view.findViewById<Button>(R.id.buttonToMain)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_helpFragment_to_mainFragment)
        }

        return view
    }

//    companion object {}
}