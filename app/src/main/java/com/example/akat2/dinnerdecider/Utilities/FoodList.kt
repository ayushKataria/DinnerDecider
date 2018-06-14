package com.example.akat2.dinnerdecider.Utilities

import android.content.Context
import com.example.akat2.dinnerdecider.fragments.ListFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * Created by Ayush Kataria on 14-06-2018.
 */
object FoodList {

    val SHARED_PREFS_FOOD_LIST = "sharedPrefsFoodList"
    val FOOD_LIST = "foodList"

    var foodList = ArrayList<String>()

    fun initFoodList(context: Context) {
        val prefs = context.getSharedPreferences(SHARED_PREFS_FOOD_LIST, Context.MODE_PRIVATE)

        val gson = Gson()
        val json = prefs.getString(FOOD_LIST, "")
        if(json.isNotEmpty()) {
            val type = object : TypeToken<ArrayList<String>>() {}.type
            foodList = gson.fromJson(json, type)
        }else{
            foodList.add("Pizza")
            foodList.add("Chinese")
            foodList.add("Burger")
            foodList.add("Dosa")
        }

    }

    fun addFood(context: Context, foodName: String) {
        foodList.add(foodName)

        val prefs = context.getSharedPreferences(SHARED_PREFS_FOOD_LIST, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = gson.toJson(foodList)

        prefs.edit().putString(FOOD_LIST, json).commit()
    }

    fun removeFood(context: Context, foodName: String) {
        foodList.remove(foodName)

        val prefs = context.getSharedPreferences(SHARED_PREFS_FOOD_LIST, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = gson.toJson(foodList)

        prefs.edit().putString(FOOD_LIST, json).commit()
    }
}