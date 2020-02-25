package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FoodFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val foodId = (0..1).shuffled().first()
            val bundle = Bundle()
            bundle.putInt("food_id", foodId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FoodDetailFragment::class.java, bundle)
                .commit()
        }
    }
}
