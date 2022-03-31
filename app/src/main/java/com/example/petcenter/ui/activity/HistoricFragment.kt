package com.example.petcenter.ui.activity.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.petcenter.R

import com.example.petcenter.database.AppDatabase
import com.example.petcenter.databinding.FragmentHistoricBinding
import com.example.petcenter.ui.recyclerview.adapter.RegisterAdapter

class HistoricFragment : Fragment() {

   // private val adapter = RegisterAdapter( requireContext())


    private var fragmentHistoricBinding: FragmentHistoricBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_historic, container, false)

    override fun onResume() {
        super.onResume()
        val binding = FragmentHistoricBinding.bind(requireView())
        fragmentHistoricBinding = binding

        val dao = AppDatabase.instancia(requireContext())
        dao.petDao().searchAll()
       //adapter.atualiza(dao.petDao().searchAll())

        binding.btnFab.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_historicFragment_to_registerFragment)
        }

        val recyclerView = binding.rvFragmentHistoric
        recyclerView.adapter = RegisterAdapter(requireContext() )

    }
}