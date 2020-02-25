package com.example.fragmenttest

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import data.MockFood
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentTest{

    @Test
    fun test_checkChefFragmentContent() {
        val chef = arrayListOf("Chef Pasta", "Chef Italian")
        val fragmentFactory = FoodFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_chef", chef)

        launchFragmentInContainer<ChefFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.chef_text)).check(matches(withText(ChefFragment.stringBuilderForMenus(chef))))
    }

    @Test
    fun test_checkFoodDetailFragmentContent() {
        val food = MockFood.PASTA
        val fragmentFactory = FoodFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("food_id", food.id)
        launchFragmentInContainer<FoodDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.food_title)).check(matches(withText(food.title)))
        onView(withId(R.id.food_description)).check(matches(withText(food.description)))
    }

    @Test
    fun test_checkMenuFragmentTest() {
        val chef = arrayListOf("Pasta, Cheese")
        val fragmentFactory = FoodFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_menu", chef)

        val scenario = launchFragmentInContainer<MenuFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.menu_text)).check(matches(withText(ChefFragment.stringBuilderForMenus(chef))))
    }
}