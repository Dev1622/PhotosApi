package com.example.photosapi.Adapter

import android.content.Context
import android.support.v7.view.menu.MenuView.ItemView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.photosapi.Model.Photo
import com.example.photosapi.R
import com.squareup.picasso.Picasso

class MyPhotoAdapter(private val context: Context,private val photoList: MutableList<Photo>) : RecyclerView.Adapter<MyPhotoAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_photo_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(photoList[position].thumbnailUrl).into(holder.image)
        holder.txt_title.text = photoList[position].title
        holder.txt_url.text = photoList[position].url
    }

    override fun getItemCount(): Int {
       return photoList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var txt_title : TextView
        var txt_url : TextView


        init {
            image = itemView.findViewById(R.id.image_photo)
            txt_title = itemView.findViewById(R.id.txt_title)
            txt_url = itemView.findViewById(R.id.txt_url)


        }

    }
}