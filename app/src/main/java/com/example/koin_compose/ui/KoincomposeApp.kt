package com.example.koin_compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.koin_compose.ui.home.HomeViewModel
import com.example.koin_compose.ui.theme.KoincomposeTheme

@Composable
fun KoincomposeApp(
    viewModel: HomeViewModel
) {
    KoincomposeTheme{
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            KoincomposeActions(navController)
        }

        KoincomposeNavGraph(
            navController = navController,
            navigateToHome = navigationActions.navigateToHome,
            navigateToDetail = navigationActions.navigateToDetail,
            viewModel = viewModel
        )
    }
}