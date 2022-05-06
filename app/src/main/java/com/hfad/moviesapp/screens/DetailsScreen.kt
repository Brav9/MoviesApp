package com.hfad.moviesapp.screens

import android.security.identity.AccessControlProfileId
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.hfad.moviesapp.MainViewModel

@Composable
fun DetailsScreen(navController: NavController, viewModel: MainViewModel, itemId: String) {
    Text("Details screen: item id: ${itemId}")
}