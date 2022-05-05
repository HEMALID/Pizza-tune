package com.example.pizzatune.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.pizzatune.databinding.FragmentProfileDilogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfileDilogFragment : DialogFragment() {

    private lateinit var binding: FragmentProfileDilogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentProfileDilogBinding.inflate(layoutInflater)

        binding.constraintLayout3.setOnClickListener {
            cameraDilog(view!!)
        }
        binding.constraintLayout2.setOnClickListener {
            galeryDilog(view!!)
        }

        return binding.root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun cameraDilog(view: View) {
        MaterialAlertDialogBuilder(context!!)
            .setTitle("Permission")
            .setMessage("Allow DelieryBoy access to your Camera. Tap Setting > permission and turn Camera to on.")
            .setNegativeButton("CANCEL") { dialog, which ->

            }
            .setPositiveButton("SETTING") { dialog, which ->

            }
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun galeryDilog(view: View) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Permission")
            .setMessage("Allow DelieryBoy access to your Storage. Tap Setting > permission and turn Camera to on.")
            .setNegativeButton("CANCEL") { dialog, which ->

            }
            .setPositiveButton("SETTING") { dialog, which ->

            }
    }


}