package com.example.videofragmanproject.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.videofragmanproject.Constant
import com.example.videofragmanproject.databinding.ActivitySplashScreenBinding


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splashStart()


        //     binding.movies.alpha = 0f
/*        binding.movies.animate().setDuration(700).translationY(100f).alpha(1f).withEndAction{
          binding.movies.animate().rotation(620f).duration = 700
          binding.tvfrg.animate().setDuration(500).translationY(0f).alpha(1f).withEndAction {
               startActivity(
                   Intent(
                       this,
                       MainActivity::class.java
                   )
               )
               finish()
           }
        //    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }*/
    }

    private fun splashStart() {
        Handler().postDelayed({ /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, Constant.SPLASH_DISPLAY_LENGTH)
    }
}
