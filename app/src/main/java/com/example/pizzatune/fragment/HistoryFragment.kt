package com.example.pizzatune.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

    lateinit var sharedPreferences: SharedPreferences
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

        val sharedPreferences = activity?.getSharedPreferences("pref", 0)
        val email = sharedPreferences?.getString("email", "")
        val password = sharedPreferences?.getString("password", "")

            if (email.equals("") && password.equals("")) {
                loginFragment()
            } else {
                historyFragment()
            }
        return binding.root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun loginFragment(){
        val fragment = UserLoginFragment()
        val fm : FragmentManager= activity!!.supportFragmentManager
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.history_fragment_container, fragment)
        ft.commit()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun historyFragment(){
        val fragment = HistoryFragment()
        val fm : FragmentManager= activity!!.supportFragmentManager
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.history_fragment_container, fragment)
        ft.commit()
    }

}