package com.example.pizzatune.menu.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzatune.databinding.FragmentTab1Binding
import com.example.pizzatune.tab1.Tab1Adapter
import com.example.pizzatune.tab1.ApiInterface
import com.example.pizzatune.tab1.model.MenuX
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Tab1Fragment : Fragment() {

    private lateinit var binding:FragmentTab1Binding

    private val BASE_URL = "http://139.59.84.117/mocha/api/"
    private lateinit var myAdapter: Tab1Adapter
    lateinit var userList: ArrayList<MenuX>
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTab1Binding.inflate(layoutInflater)

        userList = arrayListOf<MenuX>()
        linearLayoutManager = LinearLayoutManager(context)
        binding.iceCreamRecycler.layoutManager = linearLayoutManager
        myAdapter = Tab1Adapter(requireContext(), userList)
        binding.iceCreamRecycler.adapter = myAdapter

        return binding.root

    }

    private fun getData( page:Int) {
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<ArrayList<MenuX>?> {
            override fun onResponse(
                call: Call<ArrayList<MenuX>?>,
                response: Response<ArrayList<MenuX>?>
            ) {
                val responseBody = response.body()!!
                userList.addAll(responseBody)
                userList = arrayListOf<MenuX>()
                linearLayoutManager = LinearLayoutManager(context)
                binding.iceCreamRecycler.layoutManager = linearLayoutManager
                myAdapter = Tab1Adapter(requireContext(), userList)
                binding.iceCreamRecycler.adapter = myAdapter
            }

            override fun onFailure(call: Call<ArrayList<MenuX>?>, t: Throwable) {
                Log.d("MainActivity", "on failure" + t.message)
            }
        })
    }

}