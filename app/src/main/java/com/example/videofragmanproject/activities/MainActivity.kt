package com.example.videofragmanproject.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.videofragmanproject.R
import com.example.videofragmanproject.adapter.MovieAdapter
import com.example.videofragmanproject.databinding.ActivityMainBinding
import com.example.videofragmanproject.mock.MockData
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.bottom_sheet
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPagerMovie.adapter =
            MovieAdapter(supportFragmentManager, MockData.getMoviesFragment(5))
        binding.tabLayout.setupWithViewPager(viewPagerMovie)
        binding.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.white))
        setBottomSheet()
    }


    fun clickFunction(buttonSheetBehavior: BottomSheetBehavior<*>) {
        layoutSheet.setOnClickListener {
            when (buttonSheetBehavior.state) {
                BottomSheetBehavior.STATE_COLLAPSED -> buttonSheetBehavior.setState(
                    BottomSheetBehavior.STATE_EXPANDED
                )
                BottomSheetBehavior.STATE_EXPANDED -> buttonSheetBehavior.setState(
                    BottomSheetBehavior.STATE_COLLAPSED
                )
            }
        }

    }

    private fun setBottomSheet() {
        val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottom_sheet)
        clickFunction(bottomSheetBehavior)
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.isHideable = false
        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> imageBottomSheet.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                    BottomSheetBehavior.STATE_EXPANDED -> imageBottomSheet.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                    BottomSheetBehavior.STATE_DRAGGING -> imageBottomSheet.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                }
                println("state ----->>>>>>>>>>>>> $newState")
            }

            override fun onSlide(
                bottomSheet: View,
                slideOffset: Float
            ) {
                //  imageBottomSheet.setImageResource(R.mipmap.icon_bottom_sheet_default);
                println("slide ----->>>>>>>>>>>>> ")
            }
        })
    }


}
