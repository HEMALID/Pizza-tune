package com.example.pizzatune.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.pizzatune.R
import com.example.pizzatune.databinding.FragmentMenuBinding
import com.example.pizzatune.menu.tablayoutadapter.TabLayoutAdapter
import com.google.android.material.tabs.TabLayout

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)

        setupTabLayout()
        setupViewPager()

        return binding.root

    }
    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = TabLayoutAdapter(childFragmentManager, binding.tabLayout.tabCount)
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        }
    }

    private fun setupTabLayout() {
        binding.tabLayout.apply {
            addTab(this.newTab().setText("ICE CREAM"))
            addTab(this.newTab().setText("MILK SHAKE"))
            addTab(this.newTab().setText("GARLIC BREAD"))
            addTab(this.newTab().setText("PIZZAS SUPREME"))
            addTab(this.newTab().setText("STUFFED PANINI GRILLED SANDWICH"))

            // tabGravity = TabLayout.GRAVITY_FILL

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.position?.let {
                        binding.viewPager.currentItem = it
                    }
                }
                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
        }
    }



}