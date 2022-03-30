package com.example.petcenter.ui.activity.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.petcenter.R
import com.example.petcenter.dao.PetsDao
import com.example.petcenter.database.AppDatabase
import com.example.petcenter.databinding.FragmentHistoricBinding
import com.example.petcenter.model.Pet
import com.example.petcenter.ui.recyclerview.adapter.RegisterAdapter

class HistoricFragment : Fragment() {
    private val dao = PetsDao()
    private var fragmentHistoricBinding: FragmentHistoricBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_historic, container, false)


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val binding = FragmentHistoricBinding.bind(view)
//        fragmentHistoricBinding = binding
//
//
//    }

    override fun onResume() {
        super.onResume()
        val binding = FragmentHistoricBinding.bind(requireView())
        fragmentHistoricBinding = binding

        binding.btnFab.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_historicFragment_to_registerFragment)
        }

        val recyclerView = binding.rvFragmentHistoric
        recyclerView.adapter = RegisterAdapter(requireContext(), pets = dao.searchAll())

        val db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "PetCenter.db"
        ).allowMainThreadQueries()
            .build()

        val petDao = db.petDao()
        petDao.salva(
            Pet(
                name = "teste",
                tip = "testes",
                breed = "fesafaf",
                birthDate = "0f5asf"
            )
        )


    }
}