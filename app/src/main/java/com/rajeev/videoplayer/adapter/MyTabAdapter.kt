package com.rajeev.videoplayer.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rajeev.videoplayer.fragment.CompletedClassFragment
import com.rajeev.videoplayer.fragment.LiveClassesFragment
import com.rajeev.videoplayer.fragment.UpcomingClassFragment

class MyTabAdapter(
    private val myContext: Context,
    fm: FragmentManager,
    private var totalTabs: Int
) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                CompletedClassFragment()
            }

            1 -> {
                LiveClassesFragment()
            }

            2 -> {
                UpcomingClassFragment()
            }

            else -> LiveClassesFragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}