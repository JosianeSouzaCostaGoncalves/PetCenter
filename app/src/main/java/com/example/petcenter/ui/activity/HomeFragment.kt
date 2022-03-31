package com.example.petcenter.ui.activity.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.petcenter.R
import com.example.petcenter.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var fragmentHomeBinding : FragmentHomeBinding? = null

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding = binding

        binding.btnEntrar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_historicFragment2)
        }
    }
}
