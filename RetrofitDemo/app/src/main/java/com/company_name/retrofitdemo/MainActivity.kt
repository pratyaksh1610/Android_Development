package com.company_name.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.company_name.retrofitdemo.databinding.ActivityMainBinding
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val baseUrl = "https://jsonplaceholder.typicode.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //without using MVVM pattern
        getMyData()
    }

    private fun getMyData() {

        //make retrofit builder object
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiInterface::class.java)
        //will take Api Interface as parameter in above


        //to get data from retrofitBuilder variable
        val retrofitData = retrofitBuilder.getData()

        /* inside parenthesis press ctrl+shift+space button to generate
        * below code automatically*/
//        retrofitData.enqueue()
        //pass callback of object
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            //response we will get in this 'response' variable
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!

                //fetch data
                var a = ""
                for (i in responseBody) {
                    a += i.id.toString()
                    a += "  "
                }
                binding.tv.text = a

            }

            //failure in 't' variable
            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.e("error", "Error alert!")
            }
        })


    }
}