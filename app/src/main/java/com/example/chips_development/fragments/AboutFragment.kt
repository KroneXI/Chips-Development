package com.example.chips_development.fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.chips_development.R
import java.io.FileOutputStream

class AboutFragment : Fragment() {

    private var button: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.buttonToMain)
        button?.setOnClickListener(buttonsClickListener)
    }

    private val buttonsClickListener: View.OnClickListener = View.OnClickListener {
        when (it.id) {
//            R.id.buttonToMain -> {
//                context?.let { it1 -> save("test.txt", "a", it1) }
//            }
        }
    }
}