package com.codingwithmitch.espressouitestexamples.ui.movie

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.codingwithmitch.espressouitestexamples.data.Movie
import com.codingwithmitch.espressouitestexamples.databinding.LayoutMovieListItemBinding
import com.codingwithmitch.espressouitestexamples.util.MyDiffUtil

class MoviesListAdapter: RecyclerView.Adapter<MoviesListAdapter.MyViewHolder>() {

    private var oldMovieList = emptyList<Movie>()

    inner class MyViewHolder (private val binding : LayoutMovieListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun setMovieData(item: Movie){

            binding.apply {
                movieTitle.text = item.title
                Glide.with(itemView)
                    .load(item.image)
                    .into(movieImage)
                item.star_actors?.let {
                    for(index in 0 until it.size){
                        var appendValue: String = it[index]
                        if(index < (it.size - 1)){
                            appendValue += ", "
                        }
                        movieStarActors.append(appendValue)
                    }
                }

                root.setOnClickListener{
                    val action = MovieListFragmentDirections.moveToMovieDetails(item.id)
                    it.findNavController().navigate(action)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(
            LayoutMovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setMovieData(oldMovieList[position])
    }

    override fun getItemCount(): Int {
        return oldMovieList.size
    }

    fun submitList(newMovieList: List<Movie>) {
        val diffUtil = MyDiffUtil(oldMovieList, newMovieList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        oldMovieList = newMovieList
        diffResults.dispatchUpdatesTo(this)
    }
}
