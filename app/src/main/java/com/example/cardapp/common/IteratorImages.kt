package com.example.cardapp.common

import kotlin.random.Random

class IteratorImages(private val list: ArrayList<String>, current: String = "") {

    private var currentIndex: Int = if (current.isEmpty()) 0 else list.indexOf(current)


    fun get() = list[currentIndex]

    fun next(): IteratorImages {
        currentIndex = if (currentIndex == list.size - 1) currentIndex + 1 else 0
        return this
    }

    fun prev(): IteratorImages {
        currentIndex = if (currentIndex == 0) list.size - 1 else currentIndex - 1
        return this
    }

    fun random(): IteratorImages {
        currentIndex = Random.nextInt(0, list.size - 1)
        return this
    }

}