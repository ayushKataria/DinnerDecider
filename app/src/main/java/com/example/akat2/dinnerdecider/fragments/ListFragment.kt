package com.example.akat2.dinnerdecider.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.akat2.dinnerdecider.R
import com.example.akat2.dinnerdecider.adapters.FoodListAdapter
import kotlinx.android.synthetic.main.food_list_fragment.*

/**
 * Created by Ayush Kataria on 14-06-2018.
 */
class ListFragment: Fragment() {

    lateinit var adapter: FoodListAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.food_list_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FoodListAdapter(context)
        foodRecyclerView.adapter = adapter
        foodRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
            adapter.notifyDataSetChanged()
        }
    }
}