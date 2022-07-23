package com.example.petcenter.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.petcenter.model.Pet

@Dao
interface PetDao {
    @Query("SELECT * FROM pet ORDER BY name")
    fun searchAll(): List<Pet>

    @Insert
    fun salva(vararg pet: Pet)
}