package com.example.videofragmanproject.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import com.example.videofragmanproject.Constant
import com.example.videofragmanproject.R
import com.example.videofragmanproject.data.mock.MockData
import com.example.videofragmanproject.data.model.FragmanModel
import com.example.videofragmanproject.databinding.FragmentMovieBinding
import com.example.videofragmanproject.ui.adapter.ActorAdapter
import com.example.videofragmanproject.ui.adapter.FragmanAdapter
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*


class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var simpleExoPlayerMain: SimpleExoPlayer
    private lateinit var simpleExoPlayerDetail: SimpleExoPlayer
    private lateinit var mediaDataSourceFactory: DataSource.Factory
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

    //    lateinit var buttonSheetBehavior: BottomSheetBehavior<*>
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        binding.includeLayout.recycleActor.adapter = ActorAdapter(MockData.getActorList())
        setBottomSheet()
        simpleExoPlayerMain = ExoPlayerFactory.newSimpleInstance(requireActivity())
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtAnim()
        binding.recycleFrg.adapter = FragmanAdapter(MockData.getFragmanList()) { fragmentModel ->
            clickFragmentDetail(fragmentModel) // Fragment'ten activity'e ulaşıp gerekli fonksiyionu çalıştırmak için instanceof alınır.
        }.also {
            object : CountDownTimer(1000, 1000) {
                override fun onFinish() {
                    binding.recycleFrg.startLayoutAnimation()
                }

                override fun onTick(millisUntilFinished: Long) {}
            }.start()

        }
    }


    private fun txtAnim() {
        binding.txtMovieName.animate().alpha(1f).setDuration(500)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                binding.txtMovieName.animate().alpha(0f).setDuration(15000)
                    .setInterpolator(AccelerateInterpolator()).start()
            }.start()
    }

    private fun videoOynat(url: String, v: PlayerView) {
        mediaDataSourceFactory =
            DefaultDataSourceFactory(
                view?.context,
                Util.getUserAgent(view?.context, "ExoPlayerDemo")
            )
        val mediaSource =
            ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource(Uri.parse(url))
        if (v == binding.playerView) {
            simpleExoPlayerMain = ExoPlayerFactory.newSimpleInstance(requireActivity())
            simpleExoPlayerMain.prepare(mediaSource, false, false)
            simpleExoPlayerMain.playWhenReady = true
            v.player = simpleExoPlayerMain
            v.useController = false
        } else {
            simpleExoPlayerDetail = ExoPlayerFactory.newSimpleInstance(requireActivity())
            simpleExoPlayerDetail.prepare(mediaSource, false, false)
            simpleExoPlayerDetail.playWhenReady = true
            v.player = simpleExoPlayerDetail
            v.useController = false
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("TAG", "onActivity tetiklendi")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate tetiklendi")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop tetiklendi")
        txtAnim()
        simpleExoPlayerMain.playWhenReady = false
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "desteroy tetiklendi")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("TAG", "attach tetiklendi")
    }

    private fun clickFunction() {
        binding.includeLayout.clickableBottomShet
            .setOnClickListener {
                when (bottomSheetBehavior.state) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                        videoOynat(Constant.TearsOfSteel, detail_video)
                        simpleExoPlayerMain.playWhenReady = false
                        binding.includeLayout.detailVideo.startLayoutAnimation()
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        simpleExoPlayerDetail.playWhenReady = false
                        simpleExoPlayerMain.playWhenReady = true
                    }

                }
            }
    }

    private fun setBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)
        clickFunction()
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.isHideable = false
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume tetiklendi")
        txtAnim()
        videoOynat(Constant.BigBuckBunny_URL, binding.playerView)
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onpause tetiklendi")
        txtAnim()
        simpleExoPlayerMain.playWhenReady = false
        bottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
    }

    private fun clickFragmentDetail(fragmentModel: FragmanModel) {
        when (bottomSheetBehavior.state) {
            BottomSheetBehavior.STATE_COLLAPSED -> {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
            BottomSheetBehavior.STATE_EXPANDED -> {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
        binding.includeLayout.movieName.text = fragmentModel.title
    }

}