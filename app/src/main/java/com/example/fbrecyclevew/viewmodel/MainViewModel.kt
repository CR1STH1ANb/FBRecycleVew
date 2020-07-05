package com.example.fbrecyclevew.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fbrecyclevew.Producto
import com.example.fbrecyclevew.domain.data.network.Repo

class MainViewModel: ViewModel() {
    val repo= Repo()
    fun fetchUserData():LiveData<MutableList<Producto>>{
        val mutableData = MutableLiveData<MutableList<Producto>>()
        repo.getProdData().observeForever{userList ->
            mutableData.value=userList
        }
        return mutableData
    }
}