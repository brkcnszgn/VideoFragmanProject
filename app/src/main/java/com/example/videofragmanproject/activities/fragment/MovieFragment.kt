package com.example.videofragmanproject.activities.fragment

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.videofragmanproject.R
import com.example.videofragmanproject.adapter.FragmanAdapter
import com.example.videofragmanproject.databinding.FragmentMovieBinding
import com.example.videofragmanproject.mock.MockData
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_movie.bottom_sheet


class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaDataSourceFactory: DataSource.Factory
    val URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoOynat(URL)
        binding.recycleFrg.adapter = FragmanAdapter(MockData.getFragmanList()) {
            videoOynat(it.videoUrl)
        }

    }


    open fun videoOynat(url: String) {
        // yeni bir instance baslatılması
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(view?.context)

        // DataSource içerisini doldurma
        mediaDataSourceFactory =
            DefaultDataSourceFactory(
                view?.context,
                Util.getUserAgent(view?.context, "ExoPlayerDemo")
            )

        // media source nesnesine kullanılacak video türüne göre tanımlama ve url koyma islemi
        val mediaSource =
            ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource(Uri.parse(url))

        // player'ı hazır hale getirme
        simpleExoPlayer.prepare(mediaSource, false, false)

        // play oynatılmaya hazır olduğunda video oynatma islemi
        simpleExoPlayer.playWhenReady = true

        // loyout dosyasındaki id degeri eslestirme
        binding.playerView.player = simpleExoPlayer

        // player ekranına focuslanma ozelligi
        // player_view.requestFocus()
        binding.playerView.useController = false
        //setBottomSheet()
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
                    BottomSheetBehavior.STATE_COLLAPSED -> imageBottomSheet.setImageResource(R.mipmap.ic_launcher)
                    BottomSheetBehavior.STATE_EXPANDED -> imageBottomSheet.setImageResource(R.mipmap.ic_launcher)
                    BottomSheetBehavior.STATE_DRAGGING -> imageBottomSheet.setImageResource(R.mipmap.ic_launcher)
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