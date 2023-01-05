package com.example.koin_compose.ui

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.koin_compose.MainViewModel
import com.example.koin_compose.ui.home.HomeScreen
import com.example.koin_compose.ui.home.HomeViewModel

@Composable
fun KoincomposeNavGraph(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.routes,
    viewModel: HomeViewModel
) {
    NavHost(navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.Home.routes) {
            HomeScreen(
                onItemClicked = {navigateToDetail(it)},
                viewModel = viewModel
            )
        }
    }
}