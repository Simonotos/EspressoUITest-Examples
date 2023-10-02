package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.codingwithmitch.espressouitestexamples.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment(R.layout.fragment_movie_list){

    private lateinit var binding: FragmentMovieListBinding
    private val listAdapter by lazy {MoviesListAdapter()}
    private val moviesDataSource : MoviesDataSource = MoviesRemoteDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getData()
    }

    private fun getData() {
        listAdapter.submitList(moviesDataSource.getMovies())
    }

    private fun initRecyclerView() {

        binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(root.context)
                adapter = listAdapter
            }
        }

    }
}




















