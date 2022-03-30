package com.example.petcenter.ui.activity.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.petcenter.R
import com.example.petcenter.databinding.FragmentHistoricBinding
import com.example.petcenter.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var fragmentHomeBinding : FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home,container,false)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding = binding

        binding.btnEntrar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_historicFragment2)
        }
    }
}
