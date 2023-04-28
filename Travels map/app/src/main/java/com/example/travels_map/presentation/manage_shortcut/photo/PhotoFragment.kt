package com.example.travels_map.presentation.manage_shortcut.photo

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.FragmentPhotoBinding
import com.example.travels_map.domain.models.Photo
import com.example.travels_map.domain.models.User
import com.example.travels_map.presentation.manage_shortcut.TabFragment

class PhotoFragment : TabFragment(R.layout.fragment_photo) {

    override val title: String = "Фото"

    private val binding by viewBinding(FragmentPhotoBinding::bind)

    private val photoAdapter = PhotoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.photoRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photoAdapter
        }

        preInit()
    }

    private fun preInit() {
        val list = mutableListOf<Photo>()

        for (i in 0..5) {
            list.add(Photo(i, "https://image.png", User(i, "login", "password", "Name $i")))
        }

        photoAdapter.submitList(list)
    }
}