package com.codingwithmitch.espressouitestexamples.ui.movie

import androidx.test.espresso.Espresso.onView
import com.codingwithmitch.espressouitestexamples.R
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.data.FakeMovieData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieListFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val itemIndexInTest = 4
    private val movieInTest = FakeMovieData.movies[itemIndexInTest]

    @Test
    fun isMovieListVisible(){
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun itemSelected_NavigateToMovieDetail() {
        onView(withId(R.id.recycler_view)).perform(
            actionOnItemAtPosition<MoviesListAdapter.MyViewHolder>(
                itemIndexInTest, click())
        )

        onView(withId(R.id.movie_title)).check(matches(withText(movieInTest.title)))
    }

    @Test
    fun navigateToDirectorsDetails() {
        itemSelected_NavigateToMovieDetail()
        onView(withId(R.id.movie_directors)).perform(click())
        onView(withId(R.id.directors_title)).check(matches(isDisplayed()))

        val directors = movieInTest.directors
        val expectedText = directors?.let { DirectorsFragment.stringBuilderForDirectors(it) }

        onView(withId(R.id.directors_text)).check(matches(withText(expectedText)))
    }
}