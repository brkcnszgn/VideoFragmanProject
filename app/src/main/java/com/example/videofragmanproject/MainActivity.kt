package com.example.videofragmanproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videofragmanproject.adapter.MovieAdapter
import com.example.videofragmanproject.mock.MockData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerMovie.adapter =MovieAdapter(supportFragmentManager,MockData.getMoviesFragment(5))
    }




}
