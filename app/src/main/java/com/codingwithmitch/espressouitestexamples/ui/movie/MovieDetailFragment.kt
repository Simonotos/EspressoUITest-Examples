package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.Movie
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.codingwithmitch.espressouitestexamples.databinding.FragmentMovieDetailBinding


class MovieDetailFragment: Fragment(R.layout.fragment_movie_detail){

    private val TAG: String = "AppDebug"

    private lateinit var binding : FragmentMovieDetailBinding

    private lateinit var movie: Movie

    private val moviesDataSource : MoviesDataSource = MoviesRemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val itemID = requireArguments().getInt("movieID")

        moviesDataSource.getMovie(itemID)?.let{ movieFromRemote ->
            movie = movieFromRemote
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMovieDetails()

        binding.apply {

            movieDirectors.setOnClickListener {
                val action = MovieDetailFragmentDirections.moveToDirectorsDetails(movie.id)
                findNavController().navigate(action)
            }

            movieStarActors.setOnClickListener {
                val action = MovieDetailFragmentDirections.moveToStarsDetails(movie.id)
                findNavController().navigate(action)
            }
        }

    }

    private fun setMovieDetails(){

        binding.apply {
            Glide.with(this@MovieDetailFragment)
                .load(movie.image)
                .into(movieImage)
            movieTitle.text = movie.title
            movieDescription.text = movie.description
        }
    }

}

















