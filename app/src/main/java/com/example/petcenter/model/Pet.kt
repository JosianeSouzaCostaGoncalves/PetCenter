package com.example.petcenter.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pet(
    @PrimaryKey(autoGenerate = true) val id: Long= 0L,
    val name: String,
    val tip: String,
    val breed: String,
    val birthDate: String

)