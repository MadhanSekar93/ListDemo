package com.madhan.listdemo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madhan.listdemo.api.ApiConstant
import com.madhan.listdemo.model.AboutCanada
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LisViewModel : ViewModel() {
    //this is the data that we will fetch asynchronously
    private var heroList: MutableLiveData<AboutCanada?>? =
        null//we will load it asynchronously from server in this method
    //finally we will return the list
//if the list is null

    //we will call this method to get the data
    val program: LiveData<AboutCanada?>
        get() {
            //if the list is null
            if (heroList == null) {
                heroList = MutableLiveData()
                //we will load it asynchronously from server in this method
            }
            loadProgram()

            //finally we will return the list
            return heroList!!
        }

    //This method is using Retrofit to get the JSON data from URL
    fun loadProgram() {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiConstant::class.java)
        val call = api.getProgram()
        call!!.enqueue(object : Callback<AboutCanada?> {
            override fun onResponse(
                call: Call<AboutCanada?>,
                response: Response<AboutCanada?>
            ) {
                val programListModels = response.body()
                //finally we are setting the list to our MutableLiveData
                heroList!!.value = programListModels
                Log.d("guardians", "Succcsess")
            }

            override fun onFailure(
                call: Call<AboutCanada?>,
                t: Throwable
            ) {
                heroList!!.value =null
                Log.d("guardians", t.message!!)
            }
        })
    }
}