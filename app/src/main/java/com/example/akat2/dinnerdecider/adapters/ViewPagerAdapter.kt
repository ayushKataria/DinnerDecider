package com.example.akat2.dinnerdecider.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.akat2.dinnerdecider.fragments.DeciderFragment
import com.example.akat2.dinnerdecider.fragments.ListFragment

/**
 * Created by Ayush Kataria on 14-06-2018.
 */
class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    val tabTitle = arrayListOf<String>("Dinner Decider", "Food List")

    override fun getItem(position: Int): Fragment {
        return if(position == 0)
            DeciderFragment()
        else
            ListFragment()
    }

    override fun getCount(): Int {
        return tabTitle.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitle[position]
    }
}