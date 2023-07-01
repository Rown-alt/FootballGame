package com.example.footballgame.di

import com.example.footballgame.viewModels.ResultViewModel
import com.example.footballgame.viewModels.SaveResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        SaveResultViewModel(get())
    }
    viewModel{
        ResultViewModel(get())
    }
}