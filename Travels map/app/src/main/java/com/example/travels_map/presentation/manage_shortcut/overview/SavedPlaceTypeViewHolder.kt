package com.example.travels_map.presentation.manage_shortcut.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.SavedPlaceTypeLayoutBinding
import com.example.travels_map.domain.models.PlaceType

class SavedPlaceTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<SavedPlaceTypeLayoutBinding>()

    fun bind(placeType: PlaceType) {
        binding.layout.text = "Сохранено в списке «${placeType.name}»"
    }

    companion object {
        fun create(parent: ViewGroup): SavedPlaceTypeViewHolder {
            return SavedPlaceTypeViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.saved_place_type_layout, parent, false)
            )
        }
    }
}