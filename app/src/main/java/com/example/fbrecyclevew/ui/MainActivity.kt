package com.example.fbrecyclevew.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fbrecyclevew.MainAdapter
import com.example.fbrecyclevew.viewmodel.MainViewModel
import com.example.fbrecyclevew.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter= MainAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observeData()

    }
    fun observeData(){
        shimmer_view_container.startShimmer()
        viewModel.fetchUserData().observe(this, Observer{
            shimmer_view_container.stopShimmer()
            shimmer_view_container.hideShimmer()
            shimmer_view_container.visibility= View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}