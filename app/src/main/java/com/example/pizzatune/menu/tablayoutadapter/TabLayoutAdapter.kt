package com.example.pizzatune.menu.tablayoutadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pizzatune.menu.fragment.*

class TabLayoutAdapter(fm: FragmentManager, var tabCount: Int) : FragmentPagerAdapter(fm){

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            2 -> Tab3Fragment()
            3 -> Tab4Fragment()
            4 -> Tab5Fragment()
            else -> Tab1Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Tab " + (position + 1)
    }


}