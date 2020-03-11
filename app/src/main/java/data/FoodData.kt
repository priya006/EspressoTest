package data

import data.Food
import data.MockFood.BURGER
import data.MockFood.PASTA

object FoodData {

    private var FOOD_REMOTE_DATA = LinkedHashMap<Int, Food>(2)

    init {
        addFood(PASTA)
        addFood(BURGER)
    }

    fun getFood(foodId: Int): Food? {
        return FOOD_REMOTE_DATA[foodId]
    }

    private fun addFood(food: Food){
        FOOD_REMOTE_DATA.put(food.id, food)
    }


}














