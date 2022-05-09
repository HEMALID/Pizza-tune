package com.example.pizzatune.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzatune.databinding.FragmentShowProfileBinding
import com.google.gson.Gson


class ShowProfileFragment : Fragment() {

    private lateinit var binding:FragmentShowProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowProfileBinding.inflate(layoutInflater,container,false)

        /*val gson=Gson()
        val json: String=mPrefs.getString("MyObject", "")
        val obj: MyObject=gson.fromJson(json, MyObject::class.java)*/

        return binding.root
    }

}