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

        val sharedPreferences = activity?.getSharedPreferences("pref", 0)
        val emailId = sharedPreferences?.getString("email", "")
        val password = sharedPreferences?.getString("password", "")

        Handler().postDelayed({
            if (emailId.equals("") && password.equals("")) {
                loginFragment()
            } else {
                historyFragment()
            }
        },0)

        return binding.root
    }

    private fun loginFragment(){
        val fragment = UserLoginFragment()
        val fm : FragmentManager=activity?.supportFragmentManager!!
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.history_fragment_container, fragment)
        ft.commit()
    }

    private fun historyFragment(){
        val fragment = ShowHistoryFragment()
        val fm : FragmentManager=activity?.supportFragmentManager!!
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.history_fragment_container, fragment)
        ft.commit()
    }

}