package com.example.cardapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cardapp.databinding.FragmentAnimationBinding
import com.example.cardapp.databinding.FragmentCustomizationBinding

class AnimationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentAnimationBinding>(inflater,
            R.layout.fragment_animation,container,false)
        return binding.root
    }

}