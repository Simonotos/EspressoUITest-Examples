package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.data.DummyMovies.THE_RUNDOWN
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory
import com.codingwithmitch.espressouitestexamples.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest {

    @Test
    fun isMovieDataVisible(){

        val expectedMovie = THE_RUNDOWN

        //Launch Fragment
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id", expectedMovie.id)

        val fragmentScenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.movie_title)).check(matches(withText(expectedMovie.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(expectedMovie.description)))
    }
}