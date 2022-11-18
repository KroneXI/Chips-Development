package com.example.chips_development.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chips_development.R

class MainFragment : Fragment() {
//    private var button : Button? = null
//    private var textView : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        button = view.findViewById(R.id.buttonToHelp)
//        button?.setOnClickListener(buttonsClickListener)

//        textView = view.findViewById(R.id.textViewMain)
    }

//    private val  buttonsClickListener: View.OnClickListener = View.OnClickListener {
//        when (it.id) {
//            R.id.buttonToHelp -> {
////                findNavController().navigate(R.id.action_mainFragment_to_helpFragment)
//            }
//        }
//    }
}