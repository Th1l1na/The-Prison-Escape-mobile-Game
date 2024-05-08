package com.example.theprisonescape

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class FinalScoreActivity : AppCompatActivity() {

    lateinit var tv_highscore: TextView
    private lateinit var highScoreViewModel: HighScoreViewModel
    private lateinit var end_audio: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)

        highScoreViewModel = HighScoreViewModel(applicationContext)

        tv_highscore = findViewById(R.id.tv_highscore)

        //declare audio
        end_audio = MediaPlayer.create(this, R.raw.end)

//        viewModel.highScore.observe(this, Observer { highScore ->
//            tv_highscore.text = "Highscr: $highScore"
//        })

        // Start background music
        endAudio()

        highScoreViewModel.highScore.observe(this) { highScore ->
            // Update your UI element (e.g., TextView) with the high score
            tv_highscore.text = "High Score: $highScore"
        }

        val startButton: ImageButton = findViewById(R.id.start_game_button)

        startButton.setOnClickListener {
            val Intent = Intent(this, GameplayActivity::class.java)
            startActivity(Intent)
        }
    }

    private fun endAudio() {
        if (!end_audio.isPlaying) {
            end_audio.start() // Start playing the sound
        } else {
            end_audio.seekTo(0) // Rewind to the beginning
        }
    }
}