package com.example.project5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.w3c.dom.Text


class MainFragment : Fragment() {

//This is the starting screen.
    // It allows the user to select the number of questions, the difficulty, and the type of operation.
    // pressing start takes the user to the next screen.


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        // This gets access to all the elements we need on this page
        //(Radio buttons, start button, +/- buttons, and text elements)



        return view
    }

}