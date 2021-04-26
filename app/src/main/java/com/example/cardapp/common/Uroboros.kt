package com.example.cardapp.common

class Uroboros(private val list: ArrayList<String>, current: String) {

    private var currentIndex: Int

    init {
        currentIndex = list.indexOf(current)
    }

    fun get() = list[currentIndex]

    fun prev(): Uroboros {
        currentIndex--
        if (currentIndex < 0) {
            currentIndex = list.size - 1
        }
        return this
    }

    fun next(): Uroboros {
        currentIndex = if (currentIndex == 0) list.size - 1 else currentIndex - 1
        return this
    }

}