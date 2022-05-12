package com.hfad.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hfad.moviesapp.MainViewModel
import com.hfad.moviesapp.screens.DetailsScreen
import com.hfad.moviesapp.screens.MainScreen
import com.hfad.moviesapp.screens.ReviewsScreen
import com.hfad.moviesapp.screens.SplashScreen
import com.hfad.moviesapp.utils.Constants


sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
    object Reviews : Screens(route = Constants.Screens.REVIEWS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {

        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Details.route + "/{Id}") { backStackEntry ->
            DetailsScreen(
                viewModel = viewModel,
                itemId = backStackEntry.arguments?.getString("Id") ?: "1"
            )
        }
        composable(route = Screens.Reviews.route) {
            ReviewsScreen(viewModel = viewModel)
        }
    }
}