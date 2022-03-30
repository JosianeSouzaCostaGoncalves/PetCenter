package com.example.petcenter.dao

import com.example.petcenter.model.Pet

class PetsDao {

    fun add(pet: Pet){
       pets.add(pet)
    }

    fun  searchAll(): List<Pet>{
        return pets.toList()
    }

    companion object {
        private  val pets = mutableListOf<Pet>()
    }
}