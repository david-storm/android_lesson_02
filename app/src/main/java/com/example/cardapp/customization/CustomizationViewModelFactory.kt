package com.example.cardapp.customization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cardapp.source.Imagesource.impl.AssetsImageSource

class CustomizationViewModelFactory(private val imageSource: AssetsImageSource, private val backgroundSource: AssetsImageSource) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomizationViewModel::class.java)) {
            return CustomizationViewModel(imageSource, backgroundSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}