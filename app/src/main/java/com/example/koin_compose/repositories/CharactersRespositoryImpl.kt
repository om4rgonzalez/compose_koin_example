package com.example.koin_compose.repositories

import com.example.koin_compose.api.Api
import com.example.koin_compose.repositories.models.Character
import com.example.koin_compose.repositories.models.Characters
import kotlinx.coroutines.flow.Flow
import com.example.koin_compose.api.Result
import com.example.koin_compose.api.dto.toCharacter
import com.example.koin_compose.api.dto.toListCharacters
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CharactersRespositoryImpl(
    private val api: Api
): CharactersRespository {

    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow {
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(Result.Error(
                message = "Network Error",
                data = null
            ))
        }
        catch (e: IOException) {
            emit(Result.Error(
                message = "Server Error",
                data = null
            ))
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        val response = try {
            api.getCharacter(id)
        } catch (e: Exception) {
            return Result.Error(
                "Server Error"
            )
        }
        return Result.Success(response.toCharacter())
    }

}