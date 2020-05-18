package com.example.chucknorrisjokes.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisjokes.model.Joke
import kotlinx.android.synthetic.main.list_item_joke.view.*

class ChuckListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(joke: Joke) {
        itemView.value.text = joke.value
        joke.categories.forEach {
            itemView.category.text = it.toString()
        }
    }
}