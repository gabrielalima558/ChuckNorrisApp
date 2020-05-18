package com.example.chucknorrisjokes.api

import android.util.Log
import com.example.chucknorrisjokes.model.Joke
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class ChuckApi(retrofit: Retrofit) {

    private val service: ChuckService by lazy {
        retrofit.create(ChuckService::class.java)
    }
    val list = ArrayList<String>()

    fun callListCategories(lidaComSucesso: (Joke) -> Unit) {
        val observable = service.getCategories()
        observable
            .flatMap { results -> Observable.fromArray(results) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                    response.forEach {
                        list.add(it)
                    }
            }, { error ->
                Log.e("TESTEERROR", error.message.toString())

            }, {
                list.forEach {
                    callJoke(it, lidaComSucesso)
                }
            }
            )
    }

    fun callJoke(category: String, lidaComSucesso: (Joke) -> Unit) {

        val observable = service.getJokesByCategories(category)
        observable
            .flatMap { results -> Observable.fromArray(results) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response?.let(lidaComSucesso)

            }, { error ->
                Log.e("TESTEERROR", error.message.toString())
            }
            )
    }

}