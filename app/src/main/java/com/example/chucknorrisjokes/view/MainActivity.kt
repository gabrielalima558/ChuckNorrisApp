package com.example.chucknorrisjokes.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.viewmodel.ChuckViewModel
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private val viewModel: ChuckViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory).get(ChuckViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.listCategories()
        viewModel.list().observe(this, Observer {
            //imita o adapter do picpay
            it.forEach { category ->
                viewModel.getJoke(category)
                viewModel.joke().observe(this, Observer {
                    Log.e("TESTE",it.value)
                })

            }
        })
    }
}
