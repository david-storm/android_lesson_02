package com.example.cardapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cardapp.databinding.FragmentCustomizationBinding

class CustomizationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCustomizationBinding>(inflater,
            R.layout.fragment_customization,container,false)

        binding.buttonTest.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_customizationFragment_to_animationFragment)
        }
        binding.buttonLaunch.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_customizationFragment_to_animationFragment)
        }
        return binding.root
    }

}