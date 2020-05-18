package com.example.chucknorrisjokes.view

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.model.Joke
import com.example.chucknorrisjokes.viewmodel.ChuckViewModel
import com.example.chucknorrisjokes.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ChuckListAdapter

    private val viewModel: ChuckViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory).get(ChuckViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        adapter = ChuckListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        getJokesByCategory()
        setAdapterJokes()

    }

    private fun getJokesByCategory() {
        viewModel.getOther()
    }

    private fun setAdapterJokes() {
        viewModel.joke().observe(this, Observer { joke ->
            adapter.joke = teste(joke)

        })

    }

    private fun teste(joke: Joke): ArrayList<Joke> {
        val list = ArrayList<Joke>()
        list.add(joke)

        return list
    }
}
