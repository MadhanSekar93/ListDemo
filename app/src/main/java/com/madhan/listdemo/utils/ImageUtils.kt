package com.madhan.listdemo.ui.utils


import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.text.TextUtils
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.madhan.listdemo.R
import java.io.File

object ImageUtils {
    fun clearCache(context: Context) {
        Thread { Glide.get(context).clearDiskCache() }.start()
    }
//Glide to load url
    fun loadImage(imagePath: String, imageView: ImageView, @DrawableRes placeHolderId: Int) {
        if (TextUtils.isEmpty(imagePath)) {
            imageView.setImageResource(placeHolderId)
            return
        }
        val requestOptions = RequestOptions().placeholder(placeHolderId).error(placeHolderId)
        Glide.with(imageView.context).load(imagePath).apply(requestOptions).into(imageView)
    }




}
