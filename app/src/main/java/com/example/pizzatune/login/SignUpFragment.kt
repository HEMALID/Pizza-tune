package com.example.pizzatune.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzatune.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var binding:FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpBinding.inflate(layoutInflater)

        binding.logo.setOnClickListener{
            clickEvent()
        }
        binding.miniLogo.setOnClickListener{
            clickEvent()
        }


        


        return binding.root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun clickEvent(){
        val add=ProfileDilogFragment()
        add.show(activity!!.supportFragmentManager, "dialog")
    }



}