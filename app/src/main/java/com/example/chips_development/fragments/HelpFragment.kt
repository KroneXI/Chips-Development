package com.example.chips_development.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.chips_development.R

class HelpFragment : Fragment() {

    private var button: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.buttonToMain)
        button?.setOnClickListener(buttonsClickListener)
    }

    private val buttonsClickListener: View.OnClickListener = View.OnClickListener {
        when (it.id) {
//            R.id.buttonToMain -> findNavController().navigate(R.id.action_helpFragment_to_mainFragment)
        }
    }
}