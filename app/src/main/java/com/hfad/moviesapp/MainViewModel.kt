package com.hfad.moviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.moviesapp.data.models.Movies
import com.hfad.moviesapp.data.models.Review
import com.hfad.moviesapp.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _allMovies = MutableLiveData<List<Movies>>()
    val allMovies: LiveData<List<Movies>>
        get() = _allMovies

    private val _allReviews = MutableLiveData<List<Review>>()
    val allReviews: LiveData<List<Review>>
        get() = _allReviews

    fun getAllMovies() {
        viewModelScope.launch {
            repository.getAllMovies().let {
                if (it.isSuccessful) {
                    _allMovies.postValue(it.body())
                } else {
                    Log.d("checkData", "Failed to load movies: ${it.errorBody()}")
                }
            }
        }
    }

    fun getAllReviews() {
        viewModelScope.launch {
            repository.getAllReviews().let {
                if (it.isSuccessful) {
                    Log.d("OLOLO", "getAllReviews: ${it.body()}")
                    _allReviews.postValue(it.body()!!.result)
                } else {
                    Log.d("OLOLO", "Failed to load reviews: ${it.errorBody()}")
                }
            }
        }
    }

    init {
        getAllReviews()
    }
}