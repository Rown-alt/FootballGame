package com.example.footballgame.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.TimeResult
import com.example.data.TimeResultDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SaveResultViewModel(private val timeResultDao: TimeResultDao): ViewModel() {
    fun saveResult(name: String, time: String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = TimeResult(0, name, time)
            timeResultDao.insert(result)
        }
    }

    fun getResults(){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("results", timeResultDao.getAll().toString())
        }
    }
}