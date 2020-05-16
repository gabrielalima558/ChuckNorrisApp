package com.example.chucknorrisjokes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.repository.ChuckRepository
import com.example.chucknorrisjokes.api.ChuckApi
import com.example.chucknorrisjokes.api.InitRetrofit


object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val retrofit = InitRetrofit.retrofit

    private val chuckApi = ChuckApi(retrofit)

    private val chuckRepository =
        ChuckRepository(chuckApi)

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ChuckViewModel(
        chuckRepository
    ) as T

}