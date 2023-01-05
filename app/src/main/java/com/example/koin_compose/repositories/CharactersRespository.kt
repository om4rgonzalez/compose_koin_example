package com.example.koin_compose.repositories

import com.example.koin_compose.repositories.models.Characters
import com.example.koin_compose.repositories.models.Character
import kotlinx.coroutines.flow.Flow
import com.example.koin_compose.api.Result

interface CharactersRespository {

    fun getCharacters(page: Int): Flow<Result<List<Characters>>>

    suspend fun getCharacter(id: Int): Result<Character>
}