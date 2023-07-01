package com.example.footballgame.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.TimeResult
import com.example.data.TimeResultDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(private val timeResultDao: TimeResultDao): ViewModel() {
    val results= MutableLiveData<List<TimeResult>>()

    fun getResults(){
        viewModelScope.launch(Dispatchers.IO) {
            results.postValue(timeResultDao.getAll())
        }
    }
}