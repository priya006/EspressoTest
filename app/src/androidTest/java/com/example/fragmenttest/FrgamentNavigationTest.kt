package com.example.fragmenttest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentNavigationTest{

    @Test
    fun testFoodFragmentsNavigation(){
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.food_chefs)).perform(click())

        onView(withId(R.id.food_chefs_parent)).check(matches(isDisplayed()))

        pressBack()

        onView(withId(R.id.food_details_parent)).check(matches(isDisplayed()))

        onView(withId(R.id.food_menu)).perform(click())

        onView(withId(R.id.food_menu_parent)).check(matches(isDisplayed()))
    }
}