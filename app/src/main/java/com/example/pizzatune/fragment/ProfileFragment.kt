package com.example.pizzatune.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pizzatune.InviteFriendFragment
import com.example.pizzatune.R
import com.example.pizzatune.SettingFragment
import com.example.pizzatune.databinding.FragmentProfileBinding

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
        binding= FragmentProfileBinding.inflate(inflater,container,false)


        binding.navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){
                R.id.nav_setting->replaceFragment(SettingFragment(),it.title.toString())
                R.id.nav_inviteFriend->replaceFragment(InviteFriendFragment(),it.title.toString())

            }
            true
        }
        initDestinationListener()
        return binding.root
    }

    private fun initDestinationListener() {
    }

    private fun replaceFragment(fragment: Fragment,title :String){
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment_container,fragment)
        fragmentTransaction?.commit()


    }

}