package com.jty.dandelion.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jty.dandelion.home.ui.DataFragment
import com.jty.dandelion.home.ui.MineFragment
import com.jty.dandelion.home.ui.NewsFragment
import com.jty.dandelion.home.ui.PeoplesFragment

class HomeAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment = when (position) {
            0 -> NewsFragment()
            1 -> PeoplesFragment()
            2 -> DataFragment()
            else -> MineFragment()
        }

    override fun getCount(): Int = 4

}