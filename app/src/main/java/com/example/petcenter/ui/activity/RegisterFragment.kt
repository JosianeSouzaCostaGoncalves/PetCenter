package com.example.petcenter.ui.activity.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.petcenter.R
import com.example.petcenter.database.AppDatabase
import com.example.petcenter.databinding.FragmentRegisterBinding
import com.example.petcenter.model.Pet


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var fragmentRegisterFragment: FragmentRegisterBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRegisterBinding.bind(view)
        fragmentRegisterFragment = binding

        binding.btnRegisterSalvar.setOnClickListener {
            val campoName = binding.etRegisterNome
            val nome = campoName.text.toString()

            val campoTip = binding.etRegisterTip
            val tip = campoTip.text.toString()

            val campoRaca = binding.etRegisterRaca
            val raca = campoRaca.text.toString()

            val campoDate = binding.etRegisterDate
            val date = campoDate.text.toString()

            val produtoPet = Pet(
                name = nome,
                tip = tip,
                breed = raca,
                birthDate = date
            )

            val dao = AppDatabase.instancia(requireContext())
            dao.petDao().salva(produtoPet)

            Log.i(
                "dbRegister", "produto" +
                        " $produtoPet" +
                        " banco de dados: ${dao.petDao().searchAll()}"
            )

            Navigation.findNavController(view)
                .navigate(R.id.action_registerFragment_to_historicFragment)
        }


    }
}
