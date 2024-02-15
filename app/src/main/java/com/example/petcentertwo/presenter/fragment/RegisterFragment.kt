package com.example.petcentertwo.presenter.fragment

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.petcentertwo.R
import com.example.petcentertwo.databinding.FragmentRegisterBinding
import com.example.petcentertwo.presenter.repository.Repository
import com.example.petcentertwo.presenter.utils.PetFragmentViewModel
import com.example.petcentertwo.presenter.utils.PetViewModelFactory


class RegisterFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var viewModel: PetFragmentViewModel
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = PetViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[PetFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onResume() {
        super.onResume()
        checkIsCatOrDog()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDatePicker()
        spinner()


        binding.floatingActionButton.setOnClickListener {
            checkIsCatOrDog()
        }

        binding.spnRegister.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                checkIsCatOrDog()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun setDatePicker() {
        binding.etRegisterDate.setOnClickListener {
            DatePickerFragment(this).show(childFragmentManager, DatePickerFragment.TAG)
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        binding.etRegisterDate.setText("" + day + "/" + month + "/" + year)
    }

    private fun setDogImage() {
        viewModel.getDogImage()
        viewModel.myDogResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Glide.with(requireContext())
                    .load(response.body()?.url.toString())
                    .into(binding.ivRandom)
            } else {
                Log.e("Response", response.errorBody().toString())
            }
        })
    }

    private fun setCatImage() {
        viewModel.getCatImage()
        viewModel.myCatResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Glide.with(requireContext())
                    .load(response.body()?.first()?.url.toString())
                    .into(binding.ivRandom)
            } else {
                Log.e("Response", response.errorBody().toString())
            }
        })
    }

    private fun spinner(){

        val typePets = resources.getStringArray(
            R.array.TypePets
        )
        binding.spnRegister.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            typePets
        )

    }

    private fun checkIsCatOrDog(){
        if(binding.spnRegister.selectedItem.toString() == "Cachorro"){
            binding.clRegisterImage.visibility = View.VISIBLE
            setDogImage()
        }else if(binding.spnRegister.selectedItem.toString()  == "Gato"){
            binding.clRegisterImage.visibility = View.VISIBLE
            setCatImage()
        }else{
            binding.clRegisterImage.visibility = View.GONE
        }
    }
}