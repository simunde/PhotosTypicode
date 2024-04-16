package com.msid.photostypicode.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.msid.photostypicode.model.Photos
import com.msid.photostypicode.model.PhotosItem

@Dao
interface PhotosDao {

    @Query("SELECT * From photos")
    fun getAllPhotos(): LiveData<List<PhotosItem>>

    @Insert
    suspend fun insertAllPhotos(photosItem: List<PhotosItem>)
}