package com.madhan.listdemo.api

import com.madhan.listdemo.model.AboutCanada
import retrofit2.Call
import retrofit2.http.GET

interface ApiConstant {
    //Api method
    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getProgram(): Call<AboutCanada>?


    //BASE_URL CONSTANT
    companion object {
        const val BASE_URL = "https://dl.dropboxusercontent.com/"
    }
}