package com.example.travels_map.presentation.place_type_list.edit_place_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travels_map.R
import com.example.travels_map.databinding.RemovablePlaceLayoutBinding
import com.example.travels_map.domain.models.Place
import com.example.travels_map.presentation.utils.OutputFormatUtils.toText

class RemovablePlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding<RemovablePlaceLayoutBinding>()

    fun bind(place: Place, listener: RemovablePlaceViewListener) {
        with(binding) {
            textViewName.text = place.name
            textViewCoordinates.text = place.coordinates.toText()

            deleteButton.setOnClickListener { listener.onDeleteButtonClick(place) }
        }
    }

    companion object {
        fun create(parent: ViewGroup): RemovablePlaceViewHolder {
            return RemovablePlaceViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.removable_place_layout, parent, false)
            )
        }
    }

    fun interface RemovablePlaceViewListener {
        fun onDeleteButtonClick(place: Place)
    }
}