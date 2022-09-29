package com.company_name.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //api interface made to make a GET request using retrofit

    //annotation for getting data from API, return Call class of retrofit
    @GET("/posts")
    fun getData() : Call<List<MyDataItem>>

}