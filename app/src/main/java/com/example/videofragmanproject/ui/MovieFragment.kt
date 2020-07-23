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
import com.example.videofragmanproject.data.mock.MockData
import com.example.videofragmanproject.databinding.FragmentMovieBinding
import com.example.videofragmanproject.ui.adapter.FragmanAdapter
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util


class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaDataSourceFactory: DataSource.Factory
//    lateinit var buttonSheetBehavior: BottomSheetBehavior<*>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun stoppedVideo() {
        binding.playerView.player.stop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtAnim()
        // videoOynat(URL)
        binding.recycleFrg.adapter = FragmanAdapter(MockData.getFragmanList()) { fragmentModel ->
            binding.playerView.player.stop()
            (binding.root.context as MainActivity).clickFragmentDetail(fragmentModel) // Fragment'ten activity'e ulaşıp gerekli fonksiyionu çalıştırmak için instanceof alınır.
        }

            .also {
                object : CountDownTimer(1000, 1000) {
                    override fun onFinish() {
                        binding.recycleFrg.startLayoutAnimation()

                    }

                    override fun onTick(millisUntilFinished: Long) {
                    }

                }.start()

            }
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(view.context)

    }


    private fun txtAnim() {
        binding.txtMovieName.animate().alpha(1f).setDuration(500)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                binding.txtMovieName.animate().alpha(0f).setDuration(15000)
                    .setInterpolator(AccelerateInterpolator()).start()
            }.start()
    }

    fun videoOynat(url: String) {
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

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume tetiklendi")
        txtAnim()
        videoOynat(Constant.BigBuckBunny_URL)

    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop tetiklendi")
        txtAnim()
        simpleExoPlayer.playWhenReady = false
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onpause tetiklendi")
        txtAnim()
        simpleExoPlayer.playWhenReady = false

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "desteroy tetiklendi")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("TAG", "attach tetiklendi")
    }


}