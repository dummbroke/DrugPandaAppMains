package com.example.drugpandaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drugpandaapp.R
import com.example.drugpandaapp.databinding.FragmentProfileMainBinding

class ProfileMainFragment : Fragment() {

    private var _binding: FragmentProfileMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnProfileEdit.setOnClickListener {
            findNavController().navigate(R.id.action_profileMainFragment_to_profileEditFragment)
        }

        binding.btnAboutUs.setOnClickListener {
            findNavController().navigate(R.id.action_profileMainFragment_to_aboutUsFragment)
        }

        binding.btnHelp.setOnClickListener {
            findNavController().navigate(R.id.action_profileMainFragment_to_helpFragment)
        }

        binding.btnTermsAndConditions.setOnClickListener {
            findNavController().navigate(R.id.action_profileMainFragment_to_termsAndConditionsFragment)
        }

        // If you have a logout button, implement its navigation accordingly
        // binding.btnLogOut.setOnClickListener {
        //     findNavController().navigate(R.id.action_profileMainFragment_to_logOutFragment)
        // }

        val backButton: ImageButton = view.findViewById(R.id.imageButton04)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
