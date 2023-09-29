package com.codingwithmitch.espressouitestexamples

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun navigateToSecondActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Access Button and click it
        onView(withId(R.id.btnNext)).perform(click())
        //Check Second Activity is Displayed
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()))
    }
}