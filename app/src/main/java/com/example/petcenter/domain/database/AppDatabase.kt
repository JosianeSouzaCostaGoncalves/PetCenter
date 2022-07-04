package com.example.petcenter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.petcenter.database.dao.PetDao
import com.example.petcenter.model.Pet

@Database(entities = [Pet::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun petDao(): PetDao

    companion object {
        fun instancia(context: Context): AppDatabase{
           return Room.databaseBuilder(
               context,
                AppDatabase::class.java,
                "PetCenter.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}
