package com.example.videofragmanproject.mock

import androidx.fragment.app.Fragment
import com.example.videofragmanproject.fragment.MovieFragment


object MockData {
    fun getMoviesFragment(fragmentSize: Int): List<Fragment> {
        val fragmentList = ArrayList<Fragment>()
        repeat(fragmentSize) {
            val fragmentmovie = MovieFragment()
            fragmentList.add(fragmentmovie)
        }
        return fragmentList
    }
}