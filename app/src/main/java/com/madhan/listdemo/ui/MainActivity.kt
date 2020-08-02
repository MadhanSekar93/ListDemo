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
        // list layoutmanager code
        val gridLayoutManager = LinearLayoutManager(this)
        activityMainBinding!!.rvListView.setHasFixedSize(true);
        activityMainBinding!!.rvListView.setLayoutManager(gridLayoutManager);
        // empty data to set loader
        mAdapter = ListAdapter(ArrayList(), this@MainActivity, true)
        activityMainBinding!!.rvListView.setAdapter(mAdapter)

        // MVVM Viewmodel initialization code
        val model: LisViewModel = ViewModelProvider(this).get(LisViewModel::class.java)

        model.program
            .observe(this, object : Observer<AboutCanada?> {


                override fun onChanged(t: AboutCanada?) {

                    if(t==null)
                    {
                        activityMainBinding!!.rvListView.visibility =View.GONE
                        activityMainBinding!!.tvNoNetwork.visibility =View.VISIBLE
                        activityMainBinding!!.tvNoNetwork.text =getString(R.string.no_network)
                       return
                    }
                    // MVVM list set code
                    val countriesModels = t!!.rows
                    val actionBar = supportActionBar
                    actionBar!!.title=t.title
                    mAdapter = ListAdapter(countriesModels!!, this@MainActivity, false)
                    activityMainBinding!!.rvListView.setAdapter(mAdapter)
                }
            })
    }
}