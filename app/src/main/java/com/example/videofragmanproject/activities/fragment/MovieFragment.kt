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
import com.example.videofragmanproject.activities.FragmanDetailActivity
import com.example.videofragmanproject.adapter.FragmanAdapter
import com.example.videofragmanproject.mock.MockData
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment() {

    private lateinit var simpleExoPlayer: SimpleExoPlayer

    // exoPlayer'da kullanmak icin DataSource nesnesi tanımı
    private lateinit var mediaDataSourceFactory: DataSource.Factory

    // exoPlayer'da kullanılacak olan url
    val URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoOynat()
        recycle_frg.adapter = FragmanAdapter(MockData.getFragmanList()) {
            startActivity(Intent(view.context, FragmanDetailActivity::class.java))
        }


    }

    fun videoOynat() {
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
            ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource(Uri.parse(URL))

        // player'ı hazır hale getirme
        simpleExoPlayer.prepare(mediaSource, false, false)

        // play oynatılmaya hazır olduğunda video oynatma islemi
        simpleExoPlayer.playWhenReady = true

        // loyout dosyasındaki id degeri eslestirme
        player_view.player = simpleExoPlayer

        // player ekranına focuslanma ozelligi
        // player_view.requestFocus()
        player_view.useController = false
        player_view.isSoundEffectsEnabled = false
        player_view.player.audioComponent!!.volume = 0f
    }





}