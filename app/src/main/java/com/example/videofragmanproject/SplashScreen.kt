package com.example.videofragmanproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.videofragmanproject.databinding.ActivitySplashScreenBinding


class SplashScreen : AppCompatActivity() {

    lateinit var binding:  ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

   //     binding.movies.alpha = 0f
           binding.movies.animate().setDuration(700).translationY(100f).alpha(1f).withEndAction{
           binding.movies.animate().rotation(620f).duration = 700
           binding.tvfrg.animate().setDuration(500).translationY(0f).alpha(1f).withEndAction{
               startActivity(Intent(this,MainActivity::class.java))}
        //    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
    }
}
