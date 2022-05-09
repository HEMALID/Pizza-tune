package com.example.pizzatune.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.pizzatune.InviteFriendFragment
import com.example.pizzatune.R
import com.example.pizzatune.SettingFragment
import com.example.pizzatune.databinding.FragmentProfileBinding
import com.example.pizzatune.login.UserLoginFragment

class ProfileFragment : Fragment() {

    private lateinit var binding:FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileBinding.inflate(inflater, container, false)

        val sharedPreferences = activity?.getSharedPreferences("pref", 0)
        val email = sharedPreferences?.getString("email", "")
        val password = sharedPreferences?.getString("password", "")

        if (email.equals("") && password.equals("")) {
            loginFragment()
        } else {
            ProfileFragment()
        }

        return binding.root

    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun loginFragment(){
        val fragment = UserLoginFragment()
        val fm : FragmentManager= activity!!.supportFragmentManager
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.profile_fragment_container, fragment)
        ft.commit()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun ProfileFragment(){
        val fragment = ShowProfileFragment()
        val fm : FragmentManager= activity!!.supportFragmentManager
        val ft: FragmentTransaction= fm.beginTransaction()
        ft.replace(R.id.profile_fragment_container, fragment)
        ft.commit()
    }



}