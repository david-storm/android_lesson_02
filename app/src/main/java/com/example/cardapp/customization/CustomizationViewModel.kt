package com.example.cardapp.customization

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.cardapp.common.IteratorImages
import com.example.cardapp.events.SingleLiveEvent
import com.example.cardapp.source.Imagesource.impl.AssetsImageSource

class CustomizationViewModel(val itemSource: AssetsImageSource, val backgroundSource : AssetsImageSource) : ViewModel() {

    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent

    val model = CustomizationModel()
    private val itemIterator = IteratorImages(itemSource.list())
    private val backgroundIterator = IteratorImages(backgroundSource.list())


    private val _errorName = MutableLiveData<Boolean>()
    val errorName: LiveData<Boolean> = _errorName

    private val _errorTitle = MutableLiveData<Boolean>()
    val errorTitle: LiveData<Boolean> = _errorTitle

    private val _errorText = MutableLiveData<Boolean>()
    val errorText: LiveData<Boolean> = _errorText


    init {
        model.itemName = itemIterator.random().get()
        model.backgroundName = itemIterator.random().get()
    }

    fun showAnimationFragment() {
        model.apply {
            _errorName.value = name.isEmpty()
            _errorTitle.value = title.isEmpty()
            _errorText.value = text.isEmpty()
            if (!isError()) {
                Log.i("cistom", "nav")
//                _navigationLiveEvent.value =
//                    CustomizationFragmentDirections.actionSettingFragmentToAnimationFragment(model)
            }
        }
    }


    fun prevItem() {
       model.itemName = itemIterator.prev().get()
    }

    fun nextItem() {
        model.itemName = itemIterator.next().get()
    }

    fun changeBackground() {
        model.backgroundName = backgroundIterator.next().get()
    }


}