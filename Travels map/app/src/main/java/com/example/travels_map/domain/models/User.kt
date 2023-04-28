package com.example.travels_map.domain.models

data class User(
    val id: Int,
    val login: String,
    val password: String,
    val name: String,
)