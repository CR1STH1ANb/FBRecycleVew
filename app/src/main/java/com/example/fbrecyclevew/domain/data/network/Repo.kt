package com.example.fbrecyclevew.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fbrecyclevew.Producto
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import kotlinx.coroutines.processNextEventInCurrentThread


class Repo {
    fun getProdData():LiveData<MutableList<Producto>>{
        val mutableData = MutableLiveData<MutableList<Producto>>()
        FirebaseFirestore.getInstance().collection("Productos").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Producto>()
            for(document: QueryDocumentSnapshot in result){
                val imageUrl = document.getString("imageUrl")
                val nombre = document.getString("nombre")
                val descripcion = document.getString("descripcion")
                val precio = document.getString("precio")
                val producto = Producto(imageUrl!!,nombre!!,descripcion!!,precio!!)
                listData.add(producto)

            }
            mutableData.value=listData
        }
        return  mutableData
    }
}