package com.example.chucknorrisjokes.viewmodel

import androidx.lifecycle.ViewModel
import com.example.chucknorrisjokes.repository.ChuckRepository

class ChuckViewModel(private val repository: ChuckRepository): ViewModel() {
    fun list() = repository.list

    fun joke() = repository.dataJoke

    fun listCategories() = repository.getListCat()

    fun getJoke(category: String) = repository.getJoke(category)
}