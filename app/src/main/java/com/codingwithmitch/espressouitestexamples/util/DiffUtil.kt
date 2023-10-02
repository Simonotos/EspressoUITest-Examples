package com.codingwithmitch.espressouitestexamples.util

import androidx.recyclerview.widget.DiffUtil
import com.codingwithmitch.espressouitestexamples.data.Movie

class MyDiffUtil(
    private val oldList : List<Movie>,
    private val newList : List<Movie>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.count()
    }

    override fun getNewListSize(): Int {
        return newList.count()
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}