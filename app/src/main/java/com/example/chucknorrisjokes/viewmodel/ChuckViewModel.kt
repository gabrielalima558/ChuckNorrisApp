package com.example.chucknorrisjokes.viewmodel

import androidx.lifecycle.ViewModel
import com.example.chucknorrisjokes.repository.ChuckRepository

class ChuckViewModel(private val repository: ChuckRepository): ViewModel() {

    fun joke() = repository.dataJoke

    fun getOther() = repository.getListCatOther()

}