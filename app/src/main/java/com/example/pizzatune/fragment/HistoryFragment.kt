package com.example.pizzatune.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.pizzatune.R
import com.example.pizzatune.databinding.FragmentHistoryBinding
import com.example.pizzatune.login.UserLoginFragment

class HistoryFragment : Fragment() {

    private val login =UserLoginFragment()
    private lateinit var binding: FragmentHistoryBinding

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
        binding = FragmentHistoryBinding.inflate(layoutInflater)

     /*   val sharedPreferences = getSharedPreferences("pref", 0)
        val countryCode = sharedPreferences.getString("countryCode", "")
        val mobileNumber = sharedPreferences.getString("mobileNumber", "")

        Handler().postDelayed({
            if (countryCode.equals("") && mobileNumber.equals("")) {
               historyFragment()

            } else {
                loginFragment()
            }
            activity?.finish()
        }, 3000)*/

        return binding.root
    }

    fun loginFragment(){
        val fragment = HistoryFragment()
        val fm : FragmentManager= requireActivity().supportFragmentManager
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.commit()
    }

    fun historyFragment(){
        val fragment = HistoryFragment()
        val fm : FragmentManager= requireActivity().supportFragmentManager
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.commit()
    }

}