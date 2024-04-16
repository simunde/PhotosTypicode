package com.msid.photostypicode.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msid.photostypicode.api.Api
import com.msid.photostypicode.api.RetrofitHelper
import com.msid.photostypicode.model.Photos
import com.msid.photostypicode.model.PhotosItem
import com.msid.photostypicode.room.AppDatabase
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val photosDao = AppDatabase.getDatabase(application).getDao()
    val photosLiveData:LiveData<List<PhotosItem>> = photosDao.getAllPhotos()
//    private val photosMutableLiveDate = MutableLiveData<Photos>()
//    val photosLiveData : LiveData<Photos> = photosMutableLiveDate

    init {
        fetchData()
    }

    private fun fetchData() {

        viewModelScope.launch {
            val result = RetrofitHelper.getInstance().create(Api::class.java).getPhotos()
            try {
                if (result.isSuccessful){
//                    photosMutableLiveDate.value=result.body()
                    result.body()?.let {
                        photosDao.insertAllPhotos(it)
                    }
                }

            }
            catch (e:Exception){

            }
        }
    }
}