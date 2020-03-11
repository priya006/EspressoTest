package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import data.Food
import data.FoodData
import kotlinx.android.synthetic.main.fragment_food_detail.*

class FoodDetailFragment : Fragment(){

    private lateinit var food: Food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("food_id").let{ foodId ->
                FoodData.getFood(foodId)?.let{ FoodFromRemote ->
                    food = FoodFromRemote
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFoodDetails()

        food_chefs.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_chef", food.chef)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, ChefFragment::class.java, bundle)
                ?.addToBackStack("MenuFragment")
                ?.commit()
        }

        food_menu.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_menu", food.menu)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, MenuFragment::class.java, bundle)
                ?.addToBackStack("ChefFragment")
                ?.commit()
        }
    }

    private fun setFoodDetails(){
        food.let{ foodValue ->
            food_title.text = foodValue.title
            food_description.text = foodValue.description
        }
    }

}

















