package com.example.fragmenttest


import androidx.fragment.app.FragmentFactory

class FoodFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            FoodDetailFragment::class.java.name -> {
                FoodDetailFragment()
            }

            MenuFragment::class.java.name -> {
                MenuFragment()
            }

            ChefFragment::class.java.name -> {
                ChefFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}













