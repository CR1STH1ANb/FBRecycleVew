package com.example.fbrecyclevew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.api.Context
import com.google.firebase.firestore.core.View
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val context:android.content.Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<Producto>()

    fun setListData(data:MutableList<Producto>){
        dataList=data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view= LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataList.size>0){
            return dataList.size
        }else{
             return 0;
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val prod:Producto=dataList[position]
        holder.bindView(prod)
    }

    inner class MainViewHolder(itemView: android.view.View):RecyclerView.ViewHolder(itemView){
        fun bindView(prod:Producto){
            Glide.with(context).load(prod.imageUrl).into(itemView.circleImgVew)
            itemView.txt_nombre.text=prod.nombre
            itemView.txt_descripcion.text=prod.descripcion
            itemView.txt_precio.text=prod.precio

        }
    }

}