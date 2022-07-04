package com.example.petcenter.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Pet(
    @PrimaryKey(autoGenerate = true) val id: Long= 0L,
    val name: String,
    val tip: String,
    val breed: String,
    val birthDate: String
): Parcelable