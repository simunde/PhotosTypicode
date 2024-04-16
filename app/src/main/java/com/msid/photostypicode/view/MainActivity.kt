package com.msid.photostypicode.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.msid.photostypicode.R
import com.msid.photostypicode.databinding.ActivityMainBinding
import com.msid.photostypicode.model.PhotosAdapter
import com.msid.photostypicode.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PhotosAdapter
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.photosLiveData.observe(this){
            photos->
            adapter= PhotosAdapter(photos)
            binding.recyclerView.adapter=adapter
            binding.recyclerView.layoutManager=LinearLayoutManager(this)
        }
    }
}