package com.example.cardapp.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.example.cardapp.R
import com.example.cardapp.source.Imagesource.impl.AssetsImageSource

//@BindingAdapter("errorMessage")
//fun TextInputLayout.errorMessage(errorState: Boolean) {
//    error = if (errorState) {
//        resources.getString(R.string.field_is_empty)
//    } else ""
//}

@BindingAdapter("imagePath", "source")
fun ImageView.setImageFromAssets(imageName: String, source: AssetsImageSource) {
    setImageDrawable(source.getDrawable(imageName))
}

@BindingAdapter("backgroundPath", "source")
fun ImageView.setBackgroundFromAssets(imageName: String, source: AssetsImageSource) {
    setImageDrawable(source.getDrawable(imageName))
}

@BindingAdapter("multilineText")
fun TextView.multilineText(string: String) {
    val buffer = StringBuffer()
    string.forEachIndexed { index, element ->
        buffer.append(element)
        if (index % 30 == 0 && index != 0) {
            buffer.append("\n")
        }
    }
    text = buffer.toString()
}
