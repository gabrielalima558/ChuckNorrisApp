package com.example.chucknorrisjokes.repository

import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisjokes.api.ChuckApi
import com.example.chucknorrisjokes.model.Joke

class ChuckRepository(private val api: ChuckApi) {
    val list = MutableLiveData<List<String>>()
    val dataJoke = MutableLiveData<Joke>()


    fun getListCat() = api.categoriesListCall { people ->
        list.postValue(people)
    }

    fun getJoke(category: String) = api.jokesCall(category, lidaComSucesso())

    private fun lidaComSucesso(): (Joke) -> Unit {
        return { joke: Joke ->
            dataJoke.postValue(joke)
        }
    }
}