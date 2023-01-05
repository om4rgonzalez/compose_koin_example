package com.example.koin_compose.states

import com.example.koin_compose.repositories.models.Characters

data class HomeState(
    val characters: List<Characters> = emptyList(),
    val showPreview: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false
) {


}