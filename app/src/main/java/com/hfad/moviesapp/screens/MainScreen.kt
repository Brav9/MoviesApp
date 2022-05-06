package com.hfad.moviesapp.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.hfad.moviesapp.MainViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach { Log.d("checkData","ID: ${it.name}")}
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "Test")
    }
}

