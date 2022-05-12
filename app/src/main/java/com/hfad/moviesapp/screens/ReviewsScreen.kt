package com.hfad.moviesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.hfad.moviesapp.MainViewModel
import com.hfad.moviesapp.data.models.Review


@Composable
fun ReviewsScreen(viewModel: MainViewModel) {
    val allReviews = viewModel.allReviews.observeAsState(listOf()).value
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
        ) {
            items(allReviews.take(10)) { item ->
                ReviewItem(item = item)
            }
        }
    }
}

@Composable
fun ReviewItem(item: Review) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.multimedia.src),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(height = 100.dp, width = 100.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = item.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        text = item.summary,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

