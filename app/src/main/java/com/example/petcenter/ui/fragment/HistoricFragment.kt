package com.example.petcenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.petcenter.R
import com.example.petcenter.database.AppDatabase
import com.example.petcenter.databinding.FragmentHistoricBinding
import com.example.petcenter.ui.utils.adapter.RegisterAdapter

class HistoricFragment : Fragment() {

    private var _binding: FragmentHistoricBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoricBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFab.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_historicFragment_to_registerFragment)
        }
        binding.tvWelcomeText.apply {
            text = resources.getString(R.string.history_title, arguments?.getString("userName"))
        }

            // Toast.makeText(requireContext(), arguments?.getString("userName"), Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        val adapter = RegisterAdapter(requireContext())

        val dao = AppDatabase.instancia(requireContext())
        dao.petDao().searchAll()
        adapter.atualiza(dao.petDao().searchAll())

        val recyclerView = _binding!!.rvFragmentHistoric
        recyclerView.adapter = RegisterAdapter(requireContext(), dao.petDao().searchAll())

    }

}