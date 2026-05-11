package com.example.quizapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.NavbarLayoutBinding
import kotlin.jvm.java

open class BaseActivity : AppCompatActivity() {
    private lateinit var navbarBinding: NavbarLayoutBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("MusicPrefs", MODE_PRIVATE)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        setupNavbar()
        startMusicService()
    }

    private fun setupNavbar() {
        navbarBinding = NavbarLayoutBinding.bind(findViewById(R.id.navbarContainer))

        // Configuration des boutons de navigation existants
        navbarBinding.navHomeButton.setOnClickListener {
            if (this !is HomeActivity) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }

        navbarBinding.navCharactersButton.setOnClickListener {
            if (this !is CharactersActivity) {
                startActivity(Intent(this, CharactersActivity::class.java))
                finish()
            }
        }

        navbarBinding.navObjectsButton.setOnClickListener {
            if (this !is ObjectsActivity) {
                startActivity(Intent(this, ObjectsActivity::class.java))
                finish()
            }
        }

        navbarBinding.navPlacesButton.setOnClickListener {
            if (this !is PlacesActivity) {
                startActivity(Intent(this, PlacesActivity::class.java))
                finish()
            }
        }

        navbarBinding.navMoviesButton.setOnClickListener {
            if (this !is MoviesActivity) {
                startActivity(Intent(this, MoviesActivity::class.java))
                finish()
            }
        }

        navbarBinding.navQuizButton.setOnClickListener {
            if (this !is QuizActivity) {
                startActivity(Intent(this, QuizActivity::class.java))
                finish()
            }
        }



    }

    private fun startMusicService() {
        val intent = Intent(this, MusicService::class.java)
        startService(intent)
    }

    private fun muteMusic() {
        val intent = Intent(this, MusicService::class.java).apply {
            action = "MUTE"
        }
        startService(intent)
        sharedPreferences.edit().putBoolean("isMuted", true).apply()
    }

    private fun unmuteMusic() {
        val intent = Intent(this, MusicService::class.java).apply {
            action = "UNMUTE"
        }
        startService(intent)
        sharedPreferences.edit().putBoolean("isMuted", false).apply()
    }

}