package com.msid.photostypicode.api

import com.msid.photostypicode.model.Photos
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("photos")
    suspend fun getPhotos() : Response<Photos>
}