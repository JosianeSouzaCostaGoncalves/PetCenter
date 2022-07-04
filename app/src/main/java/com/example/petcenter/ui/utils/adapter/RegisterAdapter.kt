package com.example.petcenter.ui.utils.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petcenter.R
import com.example.petcenter.model.Pet

class RegisterAdapter(
    val context: Context,
    pets: List<Pet> = emptyList(),
) : RecyclerView.Adapter<RegisterAdapter.ViewHolder>() {

    private val pets = pets.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(pet: Pet) {

            val name = itemView.findViewById<TextView>(R.id.tvNamePet)
            name.text = pet.name

            val tip = itemView.findViewById<TextView>(R.id.tvTipPet)
            tip.text = pet.tip

            val breed = itemView.findViewById<TextView>(R.id.tvBreedPet)
            breed.text = pet.breed

            val birthDate = itemView.findViewById<TextView>(R.id.tvBirthDatePet)
            birthDate.text = pet.birthDate

            Log.i("petDebug", "vincula: $pet")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_my_pets, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pet = pets[position]
        holder.vincula(pet)
    }

    override fun getItemCount(): Int {
        return pets.size
    }

    fun atualiza(pets: List<Pet>) {
        this.pets.clear()
        this.pets.addAll(pets)
        notifyDataSetChanged()
    }


}
