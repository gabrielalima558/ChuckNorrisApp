package com.example.chucknorrisjokes.repository

import androidx.lifecycle.MutableLiveData
import com.example.chucknorrisjokes.api.ChuckApi
import com.example.chucknorrisjokes.model.Joke

class ChuckRepository(private val api: ChuckApi) {
    val dataJoke = MutableLiveData<Joke>()


    fun getListCatOther() {
        api.callListCategories(lidaComSucesso())
    }

    private fun lidaComSucesso(): (Joke) -> Unit {
        return { joke: Joke ->
            dataJoke.postValue(joke)
        }
    }

}