package com.example.akat2.dinnerdecider.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.akat2.dinnerdecider.R
import com.example.akat2.dinnerdecider.Utilities.FoodList
import com.example.akat2.dinnerdecider.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation = 0f

        FoodList.initFoodList(this)

        setupViewPager()

        tabs.setupWithViewPager(viewPager)
    }

    fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }

}
