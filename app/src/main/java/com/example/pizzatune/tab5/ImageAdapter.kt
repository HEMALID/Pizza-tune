package com.example.pizzatune.tab5

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(avatar_url: String?) {
    Glide.with(context).load(avatar_url).into(this)
}

