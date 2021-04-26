package com.example.cardapp.customization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.cardapp.R
import com.example.cardapp.databinding.FragmentCustomizationBinding
import com.example.cardapp.source.Imagesource.impl.AssetsImageSource


class CustomizationFragment : Fragment() {

    private lateinit var binding: FragmentCustomizationBinding
    private val viewModel: CustomizationViewModel by viewModels {
        CustomizationViewModelFactory(
            AssetsImageSource(requireContext(), "item"),
            AssetsImageSource(requireContext(), "background")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomizationBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.navigationLiveEvent.observe(viewLifecycleOwner, ::navigate)
    }

    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

//    private fun launchSave(){
//        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
//        with(sharedPref.edit()) {
//            putString("name", viewModel.model.name)
//            putString("title", viewModel.model.title)
//            putString("text", viewModel.model.text)
//            putString("item", viewModel.model.itemName)
//            putString("background", viewModel.model.backgroundName)
//            apply()
//        }
//    }
//    private fun launchLoad(){
//        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
//        val name = sharedPref.getString("name", "")!!
//        if(name  == "") return
//        viewModel.name = name
//        viewModel.title = sharedPref.getString("title", "")!!
//        viewModel.text = sharedPref.getString("text", "")!!
//        viewModel.item.value = sharedPref.getInt("item", 0)
//        viewModel.background.value = sharedPref.getInt("background", 0)
//        this.findNavController()
//            .navigate(R.id.action_customizationFragment_to_animationFragment)
//    }


}