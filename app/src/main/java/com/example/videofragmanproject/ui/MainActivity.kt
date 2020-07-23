package com.example.videofragmanproject.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.videofragmanproject.Constant
import com.example.videofragmanproject.R
import com.example.videofragmanproject.data.mock.MockData
import com.example.videofragmanproject.data.model.FragmanModel
import com.example.videofragmanproject.databinding.ActivityMainBinding
import com.example.videofragmanproject.ui.adapter.ActorAdapter
import com.example.videofragmanproject.ui.adapter.MovieAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.bottom_sheet
import kotlinx.android.synthetic.main.bottom_sheet.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

    private val bottomSheetCallback = object :
        BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            //  imageBottomSheet.setImageResource(R.mipmap.icon_bottom_sheet_default);
            println("slide ----->>>>>>>>>>>>> ")
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_COLLAPSED -> imageBottomSheet.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                BottomSheetBehavior.STATE_EXPANDED -> imageBottomSheet.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                BottomSheetBehavior.STATE_DRAGGING -> imageBottomSheet.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                }
                BottomSheetBehavior.STATE_HIDDEN -> {
                }
                BottomSheetBehavior.STATE_SETTLING -> {
                }
            }
            println("state ----->>>>>>>>>>>>> $newState")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPagerMovie.adapter =
            MovieAdapter(supportFragmentManager, MockData.getMoviesFragment(5))
        binding.tabLayout.setupWithViewPager(viewPagerMovie)
        binding.tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white))
        setBottomSheet()
        binding.includeLayout.recycleActor.adapter = ActorAdapter(MockData.getActorList())

    }


    private fun clickFunction() {
        binding.includeLayout.clickableBottomShet
            .setOnClickListener {
                when (bottomSheetBehavior.state) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

                        binding.includeLayout.detailVideo.startLayoutAnimation()
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        bottomSheetBehavior.setState(
                            BottomSheetBehavior.STATE_COLLAPSED
                        )
                        //(binding.root.context as MovieFragment).videoOynat("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")

                    }

                }
            }

    }

    private fun setBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        clickFunction()
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.isHideable = false
    }

    override fun onResume() {
        super.onResume()

        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
    }

    override fun onPause() {
        super.onPause()
        bottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
    }

    fun clickFragmentDetail(fragmentModel: FragmanModel) {
        when (bottomSheetBehavior.state) {
            BottomSheetBehavior.STATE_COLLAPSED -> bottomSheetBehavior.setState(
                BottomSheetBehavior.STATE_EXPANDED
            )
            BottomSheetBehavior.STATE_EXPANDED -> {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                (binding.root.context as MovieFragment).stoppedVideo()
                (binding.root.context as MovieFragment).videoOynat(Constant.BigBuckBunny_URL)

            }
        }

        if (bottomSheetBehavior.state == 3)
            binding.includeLayout.movieName.text = fragmentModel.title

    }


}
