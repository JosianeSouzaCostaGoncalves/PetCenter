package com.example.petcenter.ui.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.petcenter.R
import com.example.petcenter.database.AppDatabase
import com.example.petcenter.databinding.FragmentRegisterBinding
import com.example.petcenter.model.Pet
import java.util.*

class RegisterFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

            Navigation.findNavController(view)
                .navigate(R.id.action_registerFragment_to_historicFragment)
        }
        setDatePicker()
    }

    fun setDatePicker(){
        binding.etRegisterDate.setOnClickListener {
            DatePickerFragment(this).show(childFragmentManager, DatePickerFragment.TAG)
        }

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        binding.etRegisterDate.setText("" + day + "/" + month + "/" + year)
    }

}
