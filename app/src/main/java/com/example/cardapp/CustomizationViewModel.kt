package com.example.cardapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomizationViewModel : ViewModel() {


    var name: String = ""
    var title: String = ""
    var text: String = ""

    private lateinit var itemList: MutableList<Int>
    val item = MutableLiveData<Int>()

    private lateinit var backgroundList: MutableList<Int>
    val background = MutableLiveData<Int>()

    init {
        createList()
        nextItem()
        changeBackground()
    }

    private fun createList() {

        itemList = mutableListOf(
            R.drawable.fjb1,
            R.drawable.fjb2,
            R.drawable.fjb3,
            R.drawable.fjb4,
        )
        itemList.shuffle()

        backgroundList = mutableListOf(
            R.drawable.background_fire,
            R.drawable.background_rose,
            R.drawable.background_snow,
        )
        backgroundList.shuffle()
    }


    fun prevItem() {
        if (item.value != null) {
            itemList.add(0, item.value!!)
        }
        item.value = itemList.removeLast()
    }

    fun nextItem() {
        if (item.value != null) {
            itemList.add(item.value!!)
        }
        item.value = itemList.removeFirst()
    }

    fun changeBackground() {

        while (true) {
            val newBackground = backgroundList.random()
            if (newBackground != background.value) {
                background.value = newBackground
                break
            }
        }
    }

     fun validationField() : Boolean{
        if(title == "" || name == "" || text == ""){

            Log.i("validationField", false.toString())
            return false
        }
         Log.i("validationField", true.toString())
         return true
    }
}