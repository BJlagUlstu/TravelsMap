package com.example.travels_map.presentation.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentLoginBinding
import com.example.travels_map.presentation.main.MainActivity

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        with(binding) {
            signInButton.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNavigationExplore())
                (requireActivity() as MainActivity).showBottomNavigationView()
            }

            textViewSignUp.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }
        }
    }
}