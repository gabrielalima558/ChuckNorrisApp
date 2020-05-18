package com.example.chucknorrisjokes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.model.Joke


class ChuckListAdapter : RecyclerView.Adapter<ChuckListItemViewHolder>() {

    var joke = emptyList<Joke>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                ChuckListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_joke, parent, false)

        return ChuckListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChuckListItemViewHolder, position: Int) {
        holder.bind(joke[position])
    }

    override fun getItemCount(): Int = joke.size
}