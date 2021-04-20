package com.example.cardapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cardapp.databinding.FragmentCustomizationBinding
import org.json.JSONObject
import org.json.JSONStringer


class CustomizationFragment : Fragment() {

    private val viewModel: CustomizationViewModel by activityViewModels()
    private lateinit var binding: FragmentCustomizationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_customization, container, false
        )

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
            viewModel.text = binding.fieldTextEdit.text.toString()
            viewModel.title = binding.fieldTitleEdit.text.toString()
            viewModel.name = binding.fieldNameEdit.text.toString()

            if (viewModel.validationField())
                view.findNavController()
                    .navigate(R.id.action_customizationFragment_to_animationFragment)
             else
                viewMessageError()
        }

        binding.buttonLaunch.setOnClickListener { view: View ->
            if (viewModel.validationField()){
                launchSave()
                activity?.finish()
            } else
            viewMessageError()
        }

        launchLoad()
        binding.customizationViewModel = viewModel

        return binding.root
    }


    private fun launchSave(){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("name", viewModel.name)
            putString("title", viewModel.title)
            putString("text", viewModel.text)
            putInt("item", viewModel.item.value!!)
            putInt("background", viewModel.background.value!!)
            apply()
        }

    }
    private fun launchLoad(){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val name = sharedPref.getString("name", "")!!
        if(name  == "") return
        viewModel.name = name
        viewModel.title = sharedPref.getString("title", "")!!
        viewModel.text = sharedPref.getString("text", "")!!
        viewModel.item.value = sharedPref.getInt("item", 0)
        viewModel.background.value = sharedPref.getInt("background", 0)
        this.findNavController()
            .navigate(R.id.action_customizationFragment_to_animationFragment)
    }


    private fun viewMessageError() {
        Toast.makeText(
            context, getString(R.string.error_empty_field),
            Toast.LENGTH_SHORT
        ).show()
    }
}