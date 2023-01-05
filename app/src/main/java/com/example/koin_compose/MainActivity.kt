package com.example.koin_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.rememberScaffoldState
import com.example.koin_compose.api.Result
import com.example.koin_compose.ui.KoincomposeApp
import com.example.koin_compose.ui.home.HomeViewModel
import com.example.koin_compose.ui.theme.KoincomposeTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

//    val state = viewModel.state
//    val eventFlow = viewModel.eventFlow
//    val scaffoldState = rememberScaffoldState()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoincomposeApp(getViewModel())
        }
    }


}

