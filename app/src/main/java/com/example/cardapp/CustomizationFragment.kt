package com.example.cardapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cardapp.databinding.FragmentCustomizationBinding


class CustomizationFragment : Fragment() {

    private lateinit var viewModel: CustomizationViewModel
    private lateinit var binding: FragmentCustomizationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_customization, container, false
        )

        viewModel = ViewModelProvider(this).get(CustomizationViewModel::class.java)


        binding.fieldNameEdit.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus)
                viewModel.name = binding.fieldNameEdit.text.toString()
        }

        binding.fieldTitleEdit.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus)
                viewModel.title = binding.fieldTitleEdit.text.toString()
        }
        binding.fieldTextEdit.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus)
                viewModel.text = binding.fieldTextEdit.text.toString()
        }

        viewModel.item.observe(viewLifecycleOwner, Observer { item ->
            binding.itemImage.setImageResource(item)
        })
        viewModel.background.observe(viewLifecycleOwner, Observer { background ->
            binding.background.setBackgroundResource(background)
        })

        binding.buttonTest.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_customizationFragment_to_animationFragment)
        }

        binding.customizationViewModel = viewModel

        binding.buttonLaunch.setOnClickListener { view: View ->
            if (viewModel.validationField()) {
                view.findNavController()
                    .navigate(R.id.action_customizationFragment_to_animationFragment)
            } else {
                viewMessageError()
            }

        }
        return binding.root
    }


    private fun viewMessageError() {
        Toast.makeText(
            context, getString(R.string.error_empty_field),
            Toast.LENGTH_SHORT
        ).show()
    }
}