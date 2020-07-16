package com.example.videofragmanproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class MovieAdapter (
    fragmentManager: FragmentManager,
    val newsFragmentList: List<Fragment>
) :
    FragmentStatePagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getItem(position: Int): Fragment = newsFragmentList[position]

    override fun getCount(): Int = newsFragmentList.size

}
