package com.example.petcenter.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.petcenter.R
import com.example.petcenter.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEntrar.setOnClickListener {
            if (!TextUtils.isEmpty(binding.etHomeNome.text.toString())) {
                val bundle = bundleOf("userName" to binding.etHomeNome.text.toString())
                view.findNavController()
                    .navigate(R.id.action_homeFragment_to_historicFragment2, bundle)

            }
        }

        binding.tvHomeRegister.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_homeFragment_to_userRegisterFragment)
        }
    }
}