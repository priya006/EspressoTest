package com.example.fragmenttest

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    FragmentTest::class,
    FragmentNavigationTest::class
)
class FoodFragmentSuite