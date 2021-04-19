package com.example.cardapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cardapp.databinding.FragmentAnimationBinding
import com.example.cardapp.databinding.FragmentCustomizationBinding

class AnimationFragment : Fragment() {


    private lateinit var viewModel: CustomizationViewModel
    private lateinit var binding: FragmentAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_animation,container,false)

        viewModel = ViewModelProvider(this).get(CustomizationViewModel::class.java)

        binding.customizationViewModel = viewModel

//        binding.background.setBackgroundResource(viewModel.background)
//        Log.i("animation", viewModel.background.toString())

        animation()
        return binding.root
    }

    private fun animation(){


    }

}