package com.example.cardapp.customization

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

data class CustomizationModel (
    private var _name: String = "",
    private var _title: String = "",
    private var _text: String = "",
    private var _itemName: String = "",
    private var _backgroundName: String = ""
) : BaseObservable() {

    @get:Bindable
    var name: String = _name
        set(value) {
            _name = value
            field = value
//            notifyPropertyChanged(BR.name)
        }


    @get:Bindable
    var title: String = _title
        set(value) {
            _title = value
            field = value
//            notifyPropertyChanged(BR.title)
        }


    @get:Bindable
    var text: String = _text
        set(value) {
            _text = value
            field = value
//            notifyPropertyChanged(BR.text)
        }


    @get:Bindable
    var itemName: String = _itemName
        set(value) {
            _itemName = value
            field = value
//            notifyPropertyChanged(BR.imageName)
        }

    @get:Bindable
    var backgroundName: String = _backgroundName
        set(value) {
            _backgroundName = value
            field = value
//            notifyPropertyChanged(BR.backgroundName)
        }

    fun isError() =
        _name.isEmpty() || _title.isEmpty() || _text.isEmpty()
}

