package com.example.koin_compose.repositories.models

import com.example.koin_compose.api.dto.Location
import com.example.koin_compose.api.dto.Origin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val specie: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String
)
