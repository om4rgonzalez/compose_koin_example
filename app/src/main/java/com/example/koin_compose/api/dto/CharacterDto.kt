package com.example.koin_compose.api.dto

import com.example.koin_compose.repositories.models.Character

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDto.toCharacter(): Character =
    Character(
        id = id,
        name = name,
        status = status,
        specie = species,
        gender = gender,
        origin = origin,
        location = location,
        image = image
    )
