package com.company_name.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //api interface made to make/declare a GET request using retrofit

    //annotation for getting data from API, return Call class of retrofit
    //specify end point in parenthesis
    @GET("/posts")
    fun getData(): Call<List<MyDataItem>>

}