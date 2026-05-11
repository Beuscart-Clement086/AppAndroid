package com.example.quizapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private var isMuted = false

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true
        mediaPlayer.setVolume(0.3f, 0.3f)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "MUTE" -> {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                    isMuted = true
                }
            }
            "UNMUTE" -> {
                if (!mediaPlayer.isPlaying && isMuted) {
                    mediaPlayer.start()
                    isMuted = false
                }
            }
            else -> {
                if (!mediaPlayer.isPlaying && !isMuted) {
                    mediaPlayer.start()
                }
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
        mediaPlayer.release()
    }
}