package com.example.travels_map.presentation.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentRegisterBinding
import com.example.travels_map.presentation.main.MainActivity

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        with(binding) {
            signUpButton.setOnClickListener {
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToNavigationExplore())
                (requireActivity() as MainActivity).showBottomNavigationView()
            }

            textViewSignIn.setOnClickListener {
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
            }
        }
    }
}