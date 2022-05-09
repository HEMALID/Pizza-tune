package com.example.pizzatune.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzatune.databinding.FragmentUserLoginBinding


class UserLoginFragment : Fragment() {

    private lateinit var binding:FragmentUserLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserLoginBinding.inflate(inflater,container,false)

        var text = "Don't have account? Sign Up"
        val ss=SpannableString("Request")
        val clickableSpan: ClickableSpan=object : ClickableSpan() {
            override fun onClick(textView: View) {
                val intent=Intent(activity, SignUpFragment::class.java)
                startActivity(intent)
            }
        }
        ss.setSpan(clickableSpan,21,27,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(StyleSpan(Typeface.BOLD), 21, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.forSignUp.text = ss
        binding.forSignUp.movementMethod = LinkMovementMethod.getInstance()



        return binding.root
    }

}