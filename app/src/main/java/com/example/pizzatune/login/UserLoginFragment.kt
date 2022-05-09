package com.example.pizzatune.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
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
import com.example.pizzatune.BuildConfig
import com.example.pizzatune.R
import com.example.pizzatune.databinding.FragmentUserLoginBinding
import com.example.pizzatune.fragment.ProfileFragment
import com.example.pizzatune.fragment.ShowHistoryFragment
import com.example.pizzatune.fragment.ShowProfileFragment
import com.example.pizzatune.loginmodel.userlogin.ApiInterface
import com.example.pizzatune.loginmodel.userlogin.RetrofitHelper
import com.example.pizzatune.loginmodel.userlogin.model.LoginRequest
import com.example.pizzatune.loginmodel.userlogin.model.LoginResponse
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserLoginFragment : Fragment() {

    private val BASE_URL="http://139.59.84.117/mocha/api/"

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

        val text="Don't have account? Sign Up"
        val ss=SpannableString(text)
        val clickableSpan: ClickableSpan=object : ClickableSpan() {
            override fun onClick(textView: View) {
                /* val intent=Intent(activity, SignUpFragment::class.java)
                 startActivity(intent)*/
            }
        }
        ss.setSpan(clickableSpan, 20, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(StyleSpan(Typeface.BOLD), 20, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.forSignUp.text=ss
        binding.forSignUp.movementMethod=LinkMovementMethod.getInstance()

        if (BuildConfig.DEBUG) {
            binding.edEmailid.setText("jacks@mailinator.com")
            binding.edPassword.setText("123456")
        }


        binding.btnsignin.setOnClickListener {

            if (binding.emailId.editText?.text?.isEmpty()!! &&
                binding.password.editText?.text?.isEmpty()!!
            ) {
                Toast.makeText(context, "please enter value", Toast.LENGTH_SHORT).show()
            } else {
                LoginApi(
                    binding.edEmailid.text.toString(),
                    binding.edPassword.text.toString(),
                    "5",
                    "154",
                    "1234567",
                    "1"
                )
            }  //  email : jacks@mailinator.com ,"password": "123456"
        }



        return binding.root
    }


    private fun LoginApi(
        email: String,
        password: String,
        restaurant_id: String,
        user_parent_id: String,
        device_token: String,
        device_type: String
    ) {

        val api=RetrofitHelper.retrofit.create(ApiInterface::class.java)
        val response=api.createPost(
            LoginRequest(
                LoginRequest.Data(
                    email,
                    password,
                    restaurant_id,
                    user_parent_id,
                    device_token,
                    device_type
                )
            )
        )

        response?.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                val responseFromApi=response.body()!!
                if (responseFromApi.status == 1) {
                    var mPrefs: SharedPreferences=activity!!.getPreferences(MODE_PRIVATE)

                    var editor: SharedPreferences.Editor= mPrefs.edit()
                    var gson:Gson = Gson()
                    var json: String?= gson.toJson(editor)
                    editor.putString("loginName",json)
                    editor.apply()
                    login()
                    login1()
                    Toast.makeText(context, responseFromApi.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
            }
        })
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun login() {
        val fragment=ShowProfileFragment()
        val fm: FragmentManager=activity!!.supportFragmentManager
        val ft: FragmentTransaction=fm.beginTransaction()
        ft.replace(R.id.profile_fragment_container, fragment)
        ft.commit()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun login1() {
        val fragment=ShowHistoryFragment()
        val fm: FragmentManager=activity!!.supportFragmentManager
        val ft: FragmentTransaction=fm.beginTransaction()
        ft.replace(R.id.history_fragment_container, fragment)
        ft.commit()
    }

}