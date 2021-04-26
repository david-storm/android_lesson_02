package com.example.cardapp.source.Imagesource.impl

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import com.example.cardapp.source.Imagesource.ImageSource
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.lang.Exception

class AssetsImageSource @Throws(FileNotFoundException::class) constructor(
    private val context: Context,
    private val folderPath: String
) : ImageSource {

    private val listOfPath: ArrayList<String> =
        context.assets.list(folderPath)?.toList() as ArrayList<String>

    override fun getBitmap(name: String): Bitmap {

        val resource = openFile(name)
        return BitmapFactory.decodeStream(resource)
            ?: throw  Exception("Can't convert file $name to bitmap")
    }


    override fun list(): ArrayList<String> {
        return listOfPath
    }

    override fun getDrawable(name: String): Drawable {
        val resource = openFile(name)
        return Drawable.createFromStream(resource, null)
            ?: throw Exception("Can't convert file $name to drawable")
    }


    private fun openFile(name: String): InputStream {
        try {
            return context.assets.open(folderPath.plus(File.separator).plus(name))
        } catch (exc: IOException) {
            throw FileNotFoundException("No such file at $name")
        }
    }

}