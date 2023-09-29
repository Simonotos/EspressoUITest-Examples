package com.codingwithmitch.espressouitestexamples


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun showDialog_CaptureName(){

        //Launch
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val expectedName = "Simone"

        //Check Dialog being opened
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withId(R.id.etUserName)).check(matches(isDisplayed()))

        onView(withId(R.id.etUserName)).perform(typeText(expectedName))
        onView(withText(R.string.text_ok)).perform(click())

        //Make sure Dialog is gone
        onView(withId(R.id.etUserName)).check(doesNotExist())

        //Confirm text entered is the one being displayed
        onView(withId(R.id.text_name)).check(matches(withText(expectedName)))
    }
}