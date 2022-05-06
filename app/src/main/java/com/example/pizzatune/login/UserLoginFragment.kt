package com.example.pizzatune.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.example.pizzatune.MainActivity
import com.example.pizzatune.databinding.FragmentUserLoginBinding
import com.example.pizzatune.fragment.ProfileFragment
import com.example.pizzatune.loginmodel.userlogin.ApiInterface
import com.example.pizzatune.loginmodel.userlogin.RetrofitHelper
import com.example.pizzatune.loginmodel.userlogin.model.LoginRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserLoginFragment : Fragment() {

    private lateinit var binding: FragmentUserLoginBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sharedPreferences=requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentUserLoginBinding.inflate(layoutInflater, container, false)

        var text="Don't have account? Sign Up"
        val ss=SpannableString(text)
        val clickableSpan: ClickableSpan=object : ClickableSpan() {
            override fun onClick(textView: View) {
                val fragment = SignUpFragment()
                val fm: FragmentManager =activity?.supportFragmentManager!!
                val ft: FragmentTransaction=fm.beginTransaction()
                ft.commit()
            }
        }
        ss.setSpan(clickableSpan, 20, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(StyleSpan(Typeface.BOLD), 21, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.forSignUp.text=ss
        binding.forSignUp.movementMethod=LinkMovementMethod.getInstance()

        binding.btnsignin.setOnClickListener {
            if (binding.emailId.editText?.text?.isEmpty()!! &&
                binding.password.editText?.text?.isEmpty()!!
            ) {
                Toast.makeText(context, "Please enter both the values", Toast.LENGTH_SHORT).show()
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    LoginApi("jacks@mailinator.com", "123456")

                }
            }//Email id = jacks@mailinator.com ,"password" = 123456
        }



        return binding.root
    }

    private suspend fun LoginApi(email: String, password: String) {

        val apiInterFace=RetrofitHelper.retrofit.create(ApiInterface::class.java)
        val response=apiInterFace.createPost(
            LoginRequest(
                LoginRequest.Data(
                    email, password
                )
            )
        )

        lifecycleScope.launch {
            if (response!!.isSuccessful && response.body() != null) {
                val responseFromApi=response.body()!!
                if (responseFromApi.status == 1) {
                    val editor: SharedPreferences.Editor=sharedPreferences.edit()
                    editor.putString("firstName", responseFromApi.data.first_name)
                    editor.putString("lastName", responseFromApi.data.last_name)
                    editor.apply()
                    val intent=Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                    Toast.makeText(context, responseFromApi.message, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Unsuccessful message", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun clickSpan() {
    }

}