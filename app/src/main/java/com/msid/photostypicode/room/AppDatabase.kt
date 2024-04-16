package com.msid.photostypicode.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.msid.photostypicode.model.PhotosItem

@Database(entities = [PhotosItem::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getDao():PhotosDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase?=null


        fun getDatabase(context: Context) : AppDatabase{
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "photos_database"
                ).build()
                INSTANCE=instance
                instance
            }
        }
    }
}