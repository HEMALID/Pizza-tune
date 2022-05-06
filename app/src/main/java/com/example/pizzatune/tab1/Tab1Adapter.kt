package com.example.pizzatune.tab1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzatune.databinding.IceCreamLayoutBinding
import com.example.pizzatune.tab1.model.Menu

class Tab1Adapter(var con: Context, private var menulist: ArrayList<Menu.MenuX>) :
    RecyclerView.Adapter<Tab1Adapter.ViewHolder>() {

    class ViewHolder(var binding: IceCreamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Menu.MenuX) {
            binding.icmenu=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val userItemBinding = IceCreamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(userItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menulist[position])
    }

    override fun getItemCount(): Int {
        return menulist.size
    }

}