package com.rajeev.videoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.Util

class VideoPlayerActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var link: String
    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        playerView = findViewById(R.id.playerView)
        player = SimpleExoPlayer.Builder(this).build()
        playerView.player = player
        if (intent.hasExtra("data")) {
            link = intent.getStringExtra("data").toString()
        }
//        val uri = Uri.parse(link)

        val mediaItem = com.google.android.exoplayer2.MediaItem.fromUri(Uri.parse(link))
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT < 24 || player.isPlaying) {
            player.play()
        }
    }

    override fun onPause() {
        super.onPause()
        player.pause()
    }

    override fun onStop() {
        super.onStop()
        player.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}