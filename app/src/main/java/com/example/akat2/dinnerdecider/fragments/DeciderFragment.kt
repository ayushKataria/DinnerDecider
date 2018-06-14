package com.example.akat2.dinnerdecider.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.akat2.dinnerdecider.R
import com.example.akat2.dinnerdecider.Utilities.FoodList
import com.example.akat2.dinnerdecider.Utilities.FoodList.foodList
import kotlinx.android.synthetic.main.decider_fragment_layout.*
import java.util.*

/**
 * Created by Ayush Kataria on 14-06-2018.
 */
class DeciderFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.decider_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        decideButton.setOnClickListener() {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodTxt.text = foodList[randomFood]
        }

        addFoodButton.setOnClickListener() {
            val newFood = addFoodTxt.text.toString()
            FoodList.addFood(context, newFood)
            addFoodTxt.text.clear()
            Toast.makeText(context, "$newFood added to the food list", Toast.LENGTH_LONG).show()
        }

    }
}