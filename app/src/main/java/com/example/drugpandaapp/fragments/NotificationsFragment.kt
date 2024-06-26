package com.example.drugpandaapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.drugpandaapp.R

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater:LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        val backButton: ImageButton = view.findViewById(R.id.imageButton04)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }
}