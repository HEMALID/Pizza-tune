package com.example.pizzatune.tab2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzatune.databinding.IceCreamLayoutBinding
import com.example.pizzatune.tab1.Tab1Adapter
import com.example.pizzatune.tab1.model.MenuX

class Tab2Adapter(var con: Context, private var menulist: ArrayList<MenuX>) :
    RecyclerView.Adapter<Tab2Adapter.ViewHolder>() {

    class ViewHolder(var binding: IceCreamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuX) {
            binding.icMenu=item
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