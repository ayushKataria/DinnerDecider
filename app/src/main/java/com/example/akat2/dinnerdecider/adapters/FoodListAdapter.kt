package com.example.akat2.dinnerdecider.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.akat2.dinnerdecider.R
import com.example.akat2.dinnerdecider.Utilities.FoodList


/**
 * Created by Ayush Kataria on 14-06-2018.
 */
class FoodListAdapter(val context: Context): RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return FoodList.foodList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindFood(FoodList.foodList[position], this)
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        val foodNameTxt = itemView?.findViewById<TextView>(R.id.foodNameTxt)
        val removeFoodBtn = itemView?.findViewById<ImageButton>(R.id.removeFoodBtn)

        fun bindFood(foodName: String, currentAdapter: FoodListAdapter) {
            foodNameTxt?.text = foodName
            removeFoodBtn?.setOnClickListener({
                FoodList.removeFood(context, foodName)
                Toast.makeText(context, "$foodName removed from the food list", Toast.LENGTH_LONG).show()
                currentAdapter.notifyDataSetChanged()
            })
        }
    }

}