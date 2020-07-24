package com.example.videofragmanproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.videofragmanproject.R
import com.example.videofragmanproject.data.mock.MockData
import com.example.videofragmanproject.databinding.ActivityMainBinding
import com.example.videofragmanproject.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPagerMovie.adapter =
            MovieAdapter(supportFragmentManager, MockData.getMoviesFragment(5))
        binding.tabLayout.setupWithViewPager(viewPagerMovie)
        binding.tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white))
    }
}
