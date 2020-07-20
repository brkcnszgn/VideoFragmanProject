package com.example.videofragmanproject.activities.fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import com.example.videofragmanproject.activities.MainActivity
import com.example.videofragmanproject.adapter.FragmanAdapter
import com.example.videofragmanproject.databinding.FragmentMovieBinding
import com.example.videofragmanproject.mock.MockData
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaDataSourceFactory: DataSource.Factory
    lateinit var buttonSheetBehavior: BottomSheetBehavior<*>

    val URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"


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
        binding.txtMovieName.animate().alpha(1f).setDuration(1000)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction(Runnable {
                binding.txtMovieName.animate().alpha(0f).setDuration(8000)
                    .setInterpolator(AccelerateInterpolator()).start()
            }).start()
        binding.recycleFrg.adapter = FragmanAdapter(MockData.getFragmanList()) { fragmentModel ->
            //  videoOynat(it.videoUrl)
            binding.playerView.player.stop()
            (binding.root.context as MainActivity).clickFragmentDetail(fragmentModel) // Fragment'ten activity'e ulaşıp gerekli fonksiyionu çalıştırmak için instanceof alınır.
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

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("TAG", "onActivity tetiklendi")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate tetiklendi")
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG", "onResume tetiklendi")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onResume tetiklendi")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy tetiklendi")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("TAG", "onDestroy tetiklendi")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("TAG", "onDetach tetiklendi")
    }


}