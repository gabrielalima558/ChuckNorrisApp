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

    fun categoriesListCall(lidaComSucesso: (List<String>) -> Unit) {
//        if(UtilMethods.isConnectedToInternet(mContext)){
//            UtilMethods.showLoading(mContext)
        val observable = service.getCategories()
        observable
            .flatMap { results -> Observable.fromArray(results) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
//                    UtilMethods.hideLoading()
                response?.let(lidaComSucesso)
                /** loginResponse is response data class*/

            }, { error ->
                Log.e("TESTEERROR", error.message.toString())
//                    UtilMethods.hideLoading()
//                    UtilMethods.showLongToast(mContext, error.message.toString())
            }
            )
//        }else{
//            UtilMethods.showLongToast(mContext, "No Internet Connection!")
//        }
    }

    fun jokesCall(category: String, lidaComSucesso: (Joke) -> Unit) {
//        if(UtilMethods.isConnectedToInternet(mContext)){
//            UtilMethods.showLoading(mContext)
        val observable = service.getJokesByCategories(category)
        observable
            .flatMap { results -> Observable.fromArray(results) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
//                    UtilMethods.hideLoading()
                response?.let(lidaComSucesso)
                /** loginResponse is response data class*/

            }, { error ->
                Log.e("TESTEERROR", error.message.toString())
//                    UtilMethods.hideLoading()
//                    UtilMethods.showLongToast(mContext, error.message.toString())
            }
            )
//        }else{
//            UtilMethods.showLongToast(mContext, "No Internet Connection!")
//        }
    }

}