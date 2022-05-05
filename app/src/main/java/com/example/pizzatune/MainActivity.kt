package com.example.pizzatune

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.pizzatune.databinding.ActivityMainBinding
import com.example.pizzatune.fragment.HomeFragment
import com.example.pizzatune.fragment.HistoryFragment
import com.example.pizzatune.fragment.MenuFragment
import com.example.pizzatune.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    private val home = HomeFragment()
    private val login = HistoryFragment()
    private val menu = MenuFragment()
    private val profile = ProfileFragment()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFrahment(home)
                R.id.menu -> replaceFrahment(menu)
                R.id.loginPage -> replaceFrahment(login)
                R.id.profile -> replaceFrahment(profile)
            }
            true
        }
        binding.bottomNavigation.selectedItemId=R.id.home


        // StatusBarColor
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.scaelet)
        }


    }
    private fun replaceFrahment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()

        if(fragment == home){
            binding.btnCheck.visibility= View.VISIBLE
        }else{
            binding.btnCheck.visibility= View.GONE
        }
    }

}