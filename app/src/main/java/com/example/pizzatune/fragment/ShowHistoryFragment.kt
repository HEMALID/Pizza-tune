package com.example.pizzatune.fragment

import  android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pizzatune.databinding.FragmentShowHistoryBinding

class ShowHistoryFragment : Fragment() {

    private lateinit var binding: FragmentShowHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentShowHistoryBinding.inflate(layoutInflater,container,false)

        return binding.root
    }


}