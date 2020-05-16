package com.example.chucknorrisjokes.api

import com.example.chucknorrisjokes.model.Joke
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckService {
    @GET("categories")
    fun getCategories(): Observable<List<String>>

    @GET("random?")
    fun getJokesByCategories(@Query("category", encoded = true) category: String): Observable<Joke>
}