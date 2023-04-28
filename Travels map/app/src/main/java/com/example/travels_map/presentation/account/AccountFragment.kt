package com.example.travels_map.presentation.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentAccountBinding

class AccountFragment : Fragment(R.layout.fragment_account) {

    private val binding by viewBinding(FragmentAccountBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        with(binding) {
            textViewUsername.text = "Имя пользователя"
            textViewName.text = "Имя"
        }

        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        with(binding) {
            editProfileButton.setOnClickListener {
                findNavController().navigate(AccountFragmentDirections.actionNavigationAccountToEditProfileFragment())
            }

            changePasswordButton.setOnClickListener {
                findNavController().navigate(AccountFragmentDirections.actionNavigationAccountToChangePasswordFragment())
            }

            permissionsButton.setOnClickListener {
                findNavController().navigate(AccountFragmentDirections.actionNavigationAccountToPermissionsFragment())
            }

            signOutButton.setOnClickListener {  }
        }
    }
}