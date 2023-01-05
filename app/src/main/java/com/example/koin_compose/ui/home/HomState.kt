package com.example.koin_compose.ui.home

import com.example.koin_compose.repositories.models.Characters

data class HomState(
    val characters: List<Characters> = emptyList(),
    val showPreview: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false
)
