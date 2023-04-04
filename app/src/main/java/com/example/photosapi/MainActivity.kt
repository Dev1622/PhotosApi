package com.example.photosapi

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.support.v7.widget.LinearLayoutManager
//import android.support.v7.widget.RecyclerView
//import android.support.v7.widget.RecyclerView.Adapter
//import android.support.v7.widget.RecyclerView.LayoutManager
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photosapi.Adapter.MyPhotoAdapter
import com.example.photosapi.Common.Common
import com.example.photosapi.Interface.RetrofitService
import com.example.photosapi.Model.Photo
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyPhotoAdapter
    lateinit var dialog: AlertDialog




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerphotolist = findViewById<RecyclerView>(R.id.recycler_photo_list)


        mService = Common.retrofitService
        recyclerphotolist.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerphotolist.layoutManager = layoutManager
        //dialog = SpotsDialog.Builder().setCancelListener(false).setContext(this).build()
        getAllPhotoList()
    }
        private fun getAllPhotoList(){
            //dialog.show()

            mService.getPhotoList().enqueue(object : retrofit2.Callback<MutableList<Photo>>{
                override fun onResponse(call: Call<MutableList<Photo>>, response: Response<MutableList<Photo>>) {
                    val recyclerphotolist = findViewById<RecyclerView>(R.id.recycler_photo_list)
                    adapter = MyPhotoAdapter(baseContext,response.body() as MutableList<Photo>)
                    adapter.notifyDataSetChanged()
                    recyclerphotolist.adapter = adapter
                    //dialog.dismiss()
                }

                override fun onFailure(call: Call<MutableList<Photo>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }
