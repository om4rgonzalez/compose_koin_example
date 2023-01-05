package com.example.koin_compose.di

import com.example.koin_compose.api.Api
import com.example.koin_compose.repositories.CharactersRespositoryImpl
import com.example.koin_compose.MainViewModel
import com.example.koin_compose.repositories.CharactersRespository
import com.example.koin_compose.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    single<CharactersRespository> {
        CharactersRespositoryImpl(get())
    }

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        HomeViewModel(get())
    }
}