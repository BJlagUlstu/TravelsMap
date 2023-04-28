package com.example.travels_map.domain.models

data class Review(
    val id: Int,
    val text: String,
    val date: Long,
    val rating: Int,
    val user: User,
)