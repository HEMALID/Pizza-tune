package com.example.pizzatune.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzatune.R

class ImageViewPagerAdapter : RecyclerView.Adapter<ImageViewPagerAdapter.ViewHolder>() {

    private val imagesList = arrayListOf(
        R.drawable.image_000, R.drawable.image_0600, R.drawable.image_0900,
        R.drawable.image_1400, R.drawable.image_1600
    )

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item,parent,false))
    }

    override fun getItemCount(): Int = imagesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.findViewById<AppCompatImageView>(R.id.imageView).let {
            it.setImageDrawable(ContextCompat.getDrawable(it.context,imagesList[position]))
        }
        holder.view.findViewById<AppCompatTextView>(R.id.pageNumber).text = "$position"
    }
}