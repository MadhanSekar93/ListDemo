package com.madhan.listdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.madhan.listdemo.model.ListModel
import com.madhan.listdemo.R
import com.madhan.listdemo.adapter.ListAdapter
import com.madhan.listdemo.databinding.ActivityMainBinding
import com.madhan.listdemo.model.AboutCanada
import com.madhan.listdemo.viewmodels.LisViewModel

class MainActivity : AppCompatActivity() {
    private var activityMainBinding: ActivityMainBinding? = null
    private var mAdapter: ListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val gridLayoutManager = LinearLayoutManager(this)
        activityMainBinding!!.rvListView.setHasFixedSize(true);
        activityMainBinding!!.rvListView.setLayoutManager(gridLayoutManager);
        val model: LisViewModel = ViewModelProvider(this).get(LisViewModel::class.java)

        model.program
            .observe(this, object : Observer<AboutCanada?> {


                override fun onChanged(t: AboutCanada?) {

                    val countriesModels = t!!.rows
                    mAdapter = ListAdapter(countriesModels!!, this@MainActivity)
                    activityMainBinding!!.rvListView.setAdapter(mAdapter)
                }
            })
    }
}