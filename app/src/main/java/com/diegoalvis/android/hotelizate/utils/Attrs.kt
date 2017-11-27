package com.diegoalvis.android.hotelizate.utils

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.util.*

object Attrs{
    @BindingAdapter("app:imgUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: Array<String>) {
        if (url.isNotEmpty()) {
            Picasso.with(imageView.context)
                    .load(Uri.parse(url[Random().nextInt(4)]))
                    .into(imageView)
        }
    }
}