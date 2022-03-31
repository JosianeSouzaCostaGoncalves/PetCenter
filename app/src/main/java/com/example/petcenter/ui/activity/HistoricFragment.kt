package com.example.petcenter.ui.activity.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.petcenter.R
import com.example.petcenter.database.AppDatabase
import com.example.petcenter.databinding.FragmentHistoricBinding
import com.example.petcenter.ui.recyclerview.adapter.RegisterAdapter

class HistoricFragment : Fragment(R.layout.fragment_historic) {

    private var fragmentHistoricBinding: FragmentHistoricBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHistoricBinding.bind(view)
        fragmentHistoricBinding = binding

        binding.btnFab.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_historicFragment_to_registerFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        val adapter = RegisterAdapter(requireContext())

        val dao = AppDatabase.instancia(requireContext())
        dao.petDao().searchAll()
        adapter.atualiza(dao.petDao().searchAll())

        val recyclerView = fragmentHistoricBinding!!.rvFragmentHistoric
        recyclerView.adapter = RegisterAdapter(requireContext(), dao.petDao().searchAll())

    }
}