package com.neo.myapplication.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

@BindingAdapter("setRadiusImage")
fun ImageView.setRadiusImage(path : Any?) {
    Glide.with(this).load(path).transform(CenterCrop(), RoundedCorners(20)).into(this)
}

@BindingAdapter("setImage")
fun ImageView.setImage(path : String?) {
    Glide.with(this).load(path).into(this)
}