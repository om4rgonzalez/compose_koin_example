package com.example.koin_compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koin_compose.repositories.CharactersRespository
import kotlinx.coroutines.flow.Flow
import com.example.koin_compose.api.Result
import com.example.koin_compose.repositories.models.Characters
import com.example.koin_compose.repositories.models.Character
import com.example.koin_compose.states.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: CharactersRespository
): ViewModel() {

    var state by mutableStateOf(HomeState(isLoading = true))
    private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentPage = 1

    init {
        getCharacters(increase = false)
    }



    fun getCharacters(increase: Boolean) {
        viewModelScope.launch {
            if(increase)
                currentPage++
            else if(currentPage > 1)
                currentPage--
            val showPreview = currentPage > 1
            val showNext = currentPage < 42
            repository.getCharacters(currentPage).onEach { result ->
                when(result) {
                    is Result.Success -> {
                        state = state.copy(
                            characters = result.data ?: emptyList(),
                            isLoading = false,
                            showPreview = showPreview,
                            showNext = showNext
                        )
                    }
                    is Result.Error -> {
                        state = state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(UIEvent.showSnackBar(
                            result.message ?: "Unknow Error"
                        ))
                    }

                    is Result.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
    }
//
//    suspend fun getCharacter(id: Int): Result<Character> = repository.getCharacter(id)


    sealed class UIEvent {
        data class showSnackBar(val message: String): UIEvent()
    }
}